package dev.blendthink.population.ui.component.prefecture

import androidx.compose.runtime.*
import dev.blendthink.population.data.response.result.Prefecture
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text

@Composable
fun PrefCheckbox(
    prefecture: Prefecture,
    onChange: (prefecture: Prefecture, isChecked: Boolean) -> Unit,
) {
    val checkboxPrefId = "checkbox-pref-${prefecture.code}"
    val check = remember { mutableStateOf(false) }
    Li {
        Input(InputType.Checkbox) {
            id(checkboxPrefId)
            checked(check.value)
            onChange {
                check.value = it.value
                onChange(prefecture, it.value)
            }
        }
        Label(checkboxPrefId) {
            Text(prefecture.name)
        }
    }
}
