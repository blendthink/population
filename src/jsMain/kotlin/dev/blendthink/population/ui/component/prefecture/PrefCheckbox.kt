package dev.blendthink.population.ui.component.prefecture

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.blendthink.population.data.response.result.Prefecture
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text

@Composable
fun PrefCheckbox(
    prefecture: Prefecture,
    onChange: (prefCode: Int, isChecked: Boolean) -> Unit,
) {
    val checkboxPrefId = "checkbox-pref-${prefecture.code}"
    var check: Boolean by mutableStateOf(false)
    Li {
        Input(InputType.Checkbox) {
            id(checkboxPrefId)
            checked(check)
            onChange {
                check = it.value
                onChange(prefecture.code, check)
            }
        }
        Label(checkboxPrefId) {
            Text(prefecture.name)
        }
    }
}
