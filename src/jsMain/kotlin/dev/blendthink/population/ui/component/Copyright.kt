package dev.blendthink.population.ui.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Small
import org.jetbrains.compose.web.dom.Text

@Composable
fun Copyright() {
    Div {
        Small {
            Text("Copyright © 2022 blendthink")
        }
    }
}
