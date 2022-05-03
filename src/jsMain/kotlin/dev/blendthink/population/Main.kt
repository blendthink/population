package dev.blendthink.population

import dev.blendthink.population.di.ModuleGenerator
import dev.blendthink.population.ui.component.PageFooter
import dev.blendthink.population.ui.component.PageMain
import dev.blendthink.population.ui.style.AppStylesheet
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposableInBody
import org.koin.core.context.startKoin
import org.w3c.dom.url.URLSearchParams

fun main() {
    val urlParams = URLSearchParams(window.location.search)
    val apiKey = urlParams.get("apiKey") ?: throw IllegalArgumentException("Require apiKey")

    val moduleGenerator = ModuleGenerator(apiKey)
    val appModules = moduleGenerator.appModules()

    startKoin {
        modules(appModules)
    }

    renderComposableInBody {
        Style(AppStylesheet)

        PageMain()
        PageFooter()
    }
}
