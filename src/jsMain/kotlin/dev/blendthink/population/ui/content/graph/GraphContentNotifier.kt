package dev.blendthink.population.ui.content.graph

import androidx.compose.runtime.mutableStateOf
import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.repository.PopulationRepository

class GraphContentNotifier(
    private val populationRepository: PopulationRepository,
) {
    val state = mutableStateOf<GraphContentState>(GraphContentState.Initialize)

    suspend fun fetchPopulations(prefCode: Int) {
        state.value = GraphContentState.Loading
        when (val result = populationRepository.getPopulation(prefCode)) {
            is Result.Success -> {
                val populations = result.data.result.populationItems
                    .find { it.label == "総人口" }?.populations
                    ?: emptyList()
                state.value = GraphContentState.Success(populations)
            }
            is Result.Error -> {
                state.value = GraphContentState.Failure(result.exception)
            }
        }
    }
}
