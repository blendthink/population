package dev.blendthink.population.ui.content

import androidx.compose.runtime.mutableStateOf
import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.repository.PrefectureRepository

class MainContentNotifier(
    private val prefectureRepository: PrefectureRepository,
) {
    val state = mutableStateOf<MainContentState>(MainContentState.Initialize)

    suspend fun fetchPrefectures() {
        state.value = MainContentState.Loading
        when (val result = prefectureRepository.getPrefectures()) {
            is Result.Success -> {
                state.value = MainContentState.Success(result.data.result)
            }
            is Result.Error -> {
                state.value = MainContentState.Failure(result.exception)
            }
        }
    }
}
