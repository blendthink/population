package dev.blendthink.population.ui.component

import androidx.compose.runtime.Composable
import dev.blendthink.population.di.ModuleGenerator
import dev.blendthink.population.ui.page.RequireApiKeyPage
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Main
import org.koin.core.context.startKoin
import org.w3c.dom.url.URLSearchParams

@Composable
fun PageMain() {
    val urlParams = URLSearchParams(window.location.search)
    val apiKey = urlParams.get("apiKey")
        ?: return RequireApiKeyPage()

    val moduleGenerator = ModuleGenerator(apiKey)
    val appModules = moduleGenerator.appModules()

    startKoin {
        modules(appModules)
    }

    Main {

    }
}
