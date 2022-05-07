package dev.blendthink.population.ui.content.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.component.prefecture.PrefCheckboxes
import dev.blendthink.population.ui.style.AppStyle.graph
import dev.blendthink.population.ui.style.AppStyle.graphContent
import dev.blendthink.population.ui.util.Highcharts
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.koin.core.context.GlobalContext

@Composable
fun GraphContent(
    prefectures: List<Prefecture>,
    notifier: GraphContentNotifier = GlobalContext.get().get(),
) {
    val state = remember { notifier.state }
    val scope = rememberCoroutineScope()

    GraphContent(prefectures, state.value) { prefCode, isChecked ->
        scope.launch {
            println("prefCode: $prefCode, isChecked: $isChecked")
        }
    }

    LaunchedEffect(true) {
        val options = js("{}")
        Highcharts.chart(graph, options)
    }
}

@Composable
fun GraphContent(
    prefectures: List<Prefecture>,
    state: GraphContentState,
    onChange: (prefCode: Int, isChecked: Boolean) -> Unit,
) {
    Div({
        classes(graphContent)
    }) {
        Div({ id(graph) })
        PrefCheckboxes(prefectures, onChange)
    }
}
