package dev.blendthink.population.ui.content.graph

import androidx.compose.runtime.*
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.component.prefecture.PrefCheckboxes
import dev.blendthink.population.ui.style.AppStyle.graph
import dev.blendthink.population.ui.style.AppStyle.graphContent
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

    GraphContent(prefectures, state.value) { prefecture, isChecked ->
        scope.launch {
            notifier.updateGraph(prefecture, isChecked)
        }
    }

    LaunchedEffect(true) {
        Graph.initialize()
        notifier.initialize(prefectures)
    }
}

@Composable
fun GraphContent(
    prefectures: List<Prefecture>,
    state: GraphContentState,
    onChange: (prefecture: Prefecture, isChecked: Boolean) -> Unit,
) {
    Div({
        classes(graphContent)
    }) {
        Div({ id(graph) })
        PrefCheckboxes(prefectures, onChange)
    }
}
