package dev.blendthink.population.ui.content.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.component.prefecture.PrefCheckboxes
import dev.blendthink.population.ui.style.AppStyle
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.koin.core.context.GlobalContext

@Composable
fun GraphContent(
    prefectures: List<Prefecture>,
    notifier: GraphContentNotifier = GlobalContext.get().get(),
) {
    val state = remember { notifier.state }
    val dataList = remember { notifier.dataList }
    val scope = rememberCoroutineScope()

    GraphContent(dataList) { prefecture, isChecked ->
        if (state.value !is GraphContentState.Loading) {
            scope.launch {
                notifier.updateGraph(prefecture, isChecked)
            }
        }
    }

    LaunchedEffect(true) {
        Graph.initialize()
        notifier.initialize(prefectures)
    }
}

@Composable
fun GraphContent(
    dataList: Map<Int, GraphData>,
    onChange: (prefecture: Prefecture, isChecked: Boolean) -> Unit,
) {
    Div({
        classes(AppStyle.graphContent)
    }) {
        Div({ id(AppStyle.graph) })
        PrefCheckboxes(dataList, onChange)
    }
}
