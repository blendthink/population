package dev.blendthink.population.ui.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PageFooter() {
    Footer {
        Copyright()
    }
}

@Composable
private fun Copyright() {
    Div {
        Span {
            Text("Copyright © 2022 blendthink")
        }
    }
}
