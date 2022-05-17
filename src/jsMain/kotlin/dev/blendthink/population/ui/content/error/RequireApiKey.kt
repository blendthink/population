package dev.blendthink.population.ui.content.error

import androidx.compose.runtime.Composable
import dev.blendthink.population.ui.style.AppStyle
import dev.blendthink.population.ui.style.TextStyle
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*

@Composable
fun RequireApiKey() {
    Div({
        classes(AppStyle.error, TextStyle.body2)
    }) {
        P {
            Text("Please issue the API key for ")
            A("https://opendata.resas-portal.go.jp/docs/api/v1/index.html", attrs = {
                target(ATarget.Blank)
            }) {
                Text("RESAS-API")
            }
            Text(" and set it in the URL parameter.")
        }

        Br()

        P {
            Text("Example: ")
            Code({
                classes(TextStyle.caption)
            }) {
                Text("https://blendthink.github.io/population/?apiKey=xxx")
            }
        }
    }
}
