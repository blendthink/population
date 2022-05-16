package dev.blendthink.population.ui.component.prefecture

import androidx.compose.runtime.*
import dev.blendthink.population.data.response.result.Prefecture
import dev.blendthink.population.ui.content.graph.GraphData
import dev.blendthink.population.ui.style.TextStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text

@Composable
fun PrefCheckbox(
    data: Map.Entry<Int, GraphData>,
    onChange: (prefecture: Prefecture, isChecked: Boolean) -> Unit,
) {
    val prefecture = data.value.prefecture
    val checkboxPrefId = "checkbox-pref-${prefecture.code}"
    Li {
        Input(InputType.Checkbox) {
            id(checkboxPrefId)
            checked(data.value.isVisible)
            onChange {
                onChange(prefecture, it.value)
            }
        }
        Label(checkboxPrefId, attrs = {
            classes(TextStyle.subtitle2)
        }) {
            Text(prefecture.name)
        }
    }
}
