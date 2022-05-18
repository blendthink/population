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
            Text("このサイトでは ")
            A("https://opendata.resas-portal.go.jp/docs/api/v1/index.html", attrs = {
                target(ATarget.Blank)
            }) {
                Text("RESAS-API")
            }
            Text(" を利用しています。")
        }

        P {
            Text("API キーを発行して、URL パラメーターに設定してください。")
        }

        Br()

        P {
            Text("例: ")
            Code({
                classes(TextStyle.caption)
            }) {
                Text("https://blendthink.github.io/population/?apiKey=xxx")
            }
        }
    }
}
