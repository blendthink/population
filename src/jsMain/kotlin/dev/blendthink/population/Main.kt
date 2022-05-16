package dev.blendthink.population

import dev.blendthink.population.di.ModuleGenerator
import dev.blendthink.population.ui.component.Copyright
import dev.blendthink.population.ui.content.MainContent
import dev.blendthink.population.ui.style.AppStyle
import dev.blendthink.population.ui.style.AppStyle.footer
import dev.blendthink.population.ui.style.AppStyle.main
import dev.blendthink.population.ui.style.TextStyle
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Footer
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposableInBody
import org.koin.core.context.startKoin
import org.w3c.dom.url.URLSearchParams

fun main() {
    val urlParams = URLSearchParams(window.location.search)
    val apiKey = urlParams.get("apiKey") ?: ""

    val moduleGenerator = ModuleGenerator(apiKey)
    val appModules = moduleGenerator.appModules()

    startKoin {
        modules(appModules)
    }

    renderComposableInBody {
        Style(AppStyle)
        Style(TextStyle)

        Main({ classes(main) }) {
            MainContent()
        }

        Footer({ classes(footer) }) {
            Copyright()
        }
    }
}
