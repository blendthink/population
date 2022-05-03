package dev.blendthink.population

import androidx.compose.runtime.*
import dev.blendthink.population.module.ModuleGenerator
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
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

    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div({ style { padding(25.px) } }) {
            Button(attrs = {
                onClick { count -= 1 }
            }) {
                Text("-")
            }

            Span({ style { padding(15.px) } }) {
                Text("$count")
            }

            Button(attrs = {
                onClick { count += 1 }
            }) {
                Text("+")
            }

            Canvas {

            }
        }
    }
}
