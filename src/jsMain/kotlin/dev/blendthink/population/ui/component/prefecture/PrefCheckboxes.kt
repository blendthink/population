package dev.blendthink.population.ui.component.prefecture

import androidx.compose.runtime.Composable
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.content.graph.GraphData
import dev.blendthink.population.ui.style.AppStyle
import org.jetbrains.compose.web.dom.Ul

@Composable
fun PrefCheckboxes(
    dataList: Map<Int, GraphData>,
    onChange: (prefecture: Prefecture, isChecked: Boolean) -> Unit,
) {
    Ul({
        classes(AppStyle.prefCheckboxes)
    }) {
        val sortedEntries = dataList.entries.sortedBy { it.key }
        sortedEntries.forEach {
            PrefCheckbox(it, onChange)
        }
    }
}
