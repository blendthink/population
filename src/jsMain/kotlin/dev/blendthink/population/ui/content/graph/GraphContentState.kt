package dev.blendthink.population.ui.content.graph

import dev.blendthink.population.data.response.result.Population

sealed class GraphContentState {
    object Initialize: GraphContentState()

    object Loading : GraphContentState()

    data class Success(
        val populations: List<Population>,
    ) : GraphContentState()

    data class Failure(
        val exception: Exception,
    ) : GraphContentState()
}
