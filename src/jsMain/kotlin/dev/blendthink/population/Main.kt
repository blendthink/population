package dev.blendthink.population

import dev.blendthink.population.ui.component.PageFooter
import dev.blendthink.population.ui.component.PageMain
import dev.blendthink.population.ui.style.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody {
        Style(AppStylesheet)

        PageMain()
        PageFooter()
    }
}
