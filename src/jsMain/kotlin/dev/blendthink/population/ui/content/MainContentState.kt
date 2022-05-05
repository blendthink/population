package dev.blendthink.population.ui.content

import dev.blendthink.population.data.response.result.Prefecture

sealed class MainContentState {
    object Initialize: MainContentState()

    object Loading : MainContentState()

    data class Success(
        val prefectures: List<Prefecture>,
    ) : MainContentState()

    data class Failure(
        val exception: Exception,
    ) : MainContentState()
}
