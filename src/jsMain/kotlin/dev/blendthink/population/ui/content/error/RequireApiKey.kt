package dev.blendthink.population.ui.content.error

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun RequireApiKey() {
    Span {
        Text("Please set 'apiKey' in the URL parameter.")
    }
}
