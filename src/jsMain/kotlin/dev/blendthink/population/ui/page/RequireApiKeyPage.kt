package dev.blendthink.population.ui.page

import androidx.compose.runtime.Composable
import dev.blendthink.population.ui.component.PageFooter
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody

fun showRequireApiKeyPage() {
    renderComposableInBody {
        RequireApiKeyPage()
    }
}

@Composable
private fun RequireApiKeyPage() {
    Main {
        Span {
            Text("Please set 'apiKey' in the URL parameter.")
        }
    }
    PageFooter()
}
