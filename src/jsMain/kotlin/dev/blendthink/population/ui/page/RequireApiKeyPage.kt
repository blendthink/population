package dev.blendthink.population.ui.page

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun RequireApiKeyPage() {
    Main {
        Span {
            Text("Please set 'apiKey' in the URL parameter.")
        }
    }
}
