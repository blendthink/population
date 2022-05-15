package dev.blendthink.population.ui.content.graph

import dev.blendthink.population.data.response.result.Population
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.util.Point
import dev.blendthink.population.ui.util.Series

sealed class GraphContentState {
    object Initialize : GraphContentState()

    object Loading : GraphContentState()

    data class Success(
        val populations: List<Population>,
    ) : GraphContentState()

    data class Failure(
        val exception: Exception,
    ) : GraphContentState()
}

data class GraphData(
    val prefecture: Prefecture,
    val isVisible: Boolean = false,
    val populations: List<Population> = emptyList(),
) {
    val series: Series = Series().apply {
        name = prefecture.name
        data = populations.map {
            Point().apply {
                x = it.year
                y = it.value
            }
        }.toTypedArray()
    }
}
