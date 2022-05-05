package dev.blendthink.population.ui.component.prefecture

import androidx.compose.runtime.Composable
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.style.AppStyle
import org.jetbrains.compose.web.dom.Ul

@Composable
fun PrefCheckboxes(
    prefectures: List<Prefecture>,
    onChange: (prefCode: Int, isChecked: Boolean) -> Unit,
) {
    Ul({
        classes(AppStyle.prefCheckboxes)
    }) {
        for (prefecture in prefectures) {
            PrefCheckbox(prefecture, onChange)
        }
    }
}
