package dev.blendthink.population.ui.util

@JsModule("highcharts")
@JsNonModule
external class Highcharts {
    companion object {
        fun chart(renderTo: String, options: Options): Chart
    }
}
