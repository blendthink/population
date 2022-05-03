package dev.blendthink.population.ui.style

import dev.blendthink.population.ui.attr.Classes
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {
    init {
        universal style {
            margin(0.px)
        }

        className(Classes.prefCheckboxes) style {
            display(DisplayStyle.Grid)
            gridTemplateColumns("repeat(auto-fit, minmax(6rem, 1fr))")
            gap(2.cssRem)
            justifyContent(JustifyContent.Center)
            margin(1.5.cssRem)

            "li" style {
                display(DisplayStyle.Block)
            }
        }
    }
}
