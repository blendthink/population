package dev.blendthink.population.ui.component

import androidx.compose.runtime.Composable
import dev.blendthink.population.ui.style.TextStyle
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Small
import org.jetbrains.compose.web.dom.Text

@Composable
fun Copyright() {
    Div {
        Small({ classes(TextStyle.caption) }) {
            Text("Copyright © 2022 blendthink")
        }
    }
}
