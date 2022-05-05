package dev.blendthink.population.ui.content

import androidx.compose.runtime.mutableStateOf
import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.repository.PopulationRepository
import dev.blendthink.population.data.repository.PrefectureRepository
import dev.blendthink.population.data.response.result.Population
import dev.blendthink.population.data.response.result.Prefecture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainContentNotifier(
    private val prefectureRepository: PrefectureRepository,
    private val populationRepository: PopulationRepository,
    private val coroutineScope: CoroutineScope,
) {
    val prefectures = mutableStateOf<List<Prefecture>>(emptyList())

    val populations = mutableStateOf<Map<Int, List<Population>>>(emptyMap())

    fun fetchPrefectures() {
        coroutineScope.launch {
            when (val result = prefectureRepository.getPrefectures()) {
                is Result.Success -> {
                    prefectures.value = result.data.result
                }
                is Result.Error -> {

                }
            }
        }
    }

    fun fetchPopulations(prefCode: Int, isChecked: Boolean) {
        coroutineScope.launch {
            when (val result = populationRepository.getPopulation(prefCode)) {
                is Result.Success -> {
                    val pops = result.data.result.populationItems.find { it.label == "" }?.populations ?: return@launch
                    populations.value = mapOf(prefCode to pops)
                }
                is Result.Error -> {

                }
            }
        }
    }
}
