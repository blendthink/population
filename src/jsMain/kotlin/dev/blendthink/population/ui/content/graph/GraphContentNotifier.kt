package dev.blendthink.population.ui.content.graph

import androidx.compose.runtime.mutableStateOf
import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.repository.PopulationRepository
import dev.blendthink.population.data.response.result.Prefecture

class GraphContentNotifier(
    private val populationRepository: PopulationRepository,
) {
    private val dataList = mutableMapOf<Int, GraphData>()

    val state = mutableStateOf<GraphContentState>(GraphContentState.Initialize)

    fun initialize(prefectures: List<Prefecture>) {
        dataList.putAll(prefectures.associate { it.code to GraphData(it) })
    }

    private suspend fun fetchPopulations(prefecture: Prefecture) {
        state.value = GraphContentState.Loading
        when (val result = populationRepository.getPopulation(prefecture.code)) {
            is Result.Success -> {
                val populations = result.data.result.populationItems.find {
                    it.label == "総人口"
                }?.populations ?: emptyList()
                state.value = GraphContentState.Success(populations)
                dataList[prefecture.code] = GraphData(
                    prefecture = prefecture,
                    isVisible = true,
                    populations = populations,
                )
            }
            is Result.Error -> {
                state.value = GraphContentState.Failure(result.exception)
            }
        }
    }

    suspend fun updateGraph(prefecture: Prefecture, checked: Boolean) {
        val data = dataList[prefecture.code]
        if (checked) {
            val isEmptyData = data?.populations.isNullOrEmpty()
            if (isEmptyData) {
                fetchPopulations(prefecture)
            }
            Graph.addData(dataList.getValue(prefecture.code))
        } else {
            data?.let {
                Graph.removeData(it)
            }
        }
    }
}
