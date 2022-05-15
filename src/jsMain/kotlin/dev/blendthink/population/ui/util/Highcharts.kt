package dev.blendthink.population.ui.util

@JsModule("highcharts")
@JsNonModule
external object Highcharts {
    val charts: Array<Chart>
    fun setOptions(options: Options)
    fun chart(renderTo: String, options: Options): Chart
}

fun LangOptions(): LangOptions = generateJsCode()
fun Options(): Options = generateJsCode()
fun TitleOptions(): TitleOptions = generateJsCode()
fun SubTitleOptions(): SubTitleOptions = generateJsCode()
fun TooltipOptions(): TooltipOptions = generateJsCode()
fun LegendOptions(): LegendOptions = generateJsCode()
fun ResponsiveRulesConditionOptions(): ResponsiveRulesConditionOptions = generateJsCode()
fun ResponsiveRulesOptions(): ResponsiveRulesOptions = generateJsCode()
fun ResponsiveOptions(): ResponsiveOptions = generateJsCode()
fun XAxisTitleOptions(): XAxisTitleOptions = generateJsCode()
fun XAxisOptions(): XAxisOptions = generateJsCode()
fun YAxisTitleOptions(): YAxisTitleOptions = generateJsCode()
fun YAxisOptions(): YAxisOptions = generateJsCode()
fun Series(): Series = generateJsCode()
fun Point(): Point = generateJsCode()

private fun <T> generateJsCode(): T = js("{}").unsafeCast<T>()

external interface Point {
    var x: Number?
        get() = definedExternally
        set(value) = definedExternally
    var y: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Series {
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var data: Array<Point>?
        get() = definedExternally
        set(value) = definedExternally

    fun remove()
}

external class Chart {
    var series: Array<Series>
    fun addSeries(series: Series, redraw: Boolean = definedExternally, animation: Boolean = definedExternally)
}

external interface LangOptions {
    var thousandsSep: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TitleOptions {
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SubTitleOptions {
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TooltipOptions {
    var valueSuffix: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LegendOptions {
    var layout: String? /* "horizontal" | "proximate" | "vertical" */
        get() = definedExternally
        set(value) = definedExternally
    var align: String? /* "center" | "left" | "right" */
        get() = definedExternally
        set(value) = definedExternally
    var verticalAlign: String? /* "bottom" | "middle" | "top" */
        get() = definedExternally
        set(value) = definedExternally
    var borderWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ResponsiveRulesConditionOptions {
    var maxWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ResponsiveRulesOptions {
    var chartOptions: Options?
        get() = definedExternally
        set(value) = definedExternally
    var condition: ResponsiveRulesConditionOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ResponsiveOptions {
    var rules: Array<ResponsiveRulesOptions>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface XAxisTitleOptions {
    var align: String? /* "high" | "low" | "middle" */
        get() = definedExternally
        set(value) = definedExternally
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var x: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface XAxisOptions {
    var title: XAxisTitleOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface YAxisTitleOptions {
    var align: String? /* "high" | "low" | "middle" */
        get() = definedExternally
        set(value) = definedExternally
    var rotation: Number?
        get() = definedExternally
        set(value) = definedExternally
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var y: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface YAxisOptions {
    var title: YAxisTitleOptions?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Options {
    var lang: LangOptions?
        get() = definedExternally
        set(value) = definedExternally
    var title: TitleOptions?
        get() = definedExternally
        set(value) = definedExternally
    var subtitle: SubTitleOptions?
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: TooltipOptions?
        get() = definedExternally
        set(value) = definedExternally
    var legend: LegendOptions?
        get() = definedExternally
        set(value) = definedExternally
    var responsive: ResponsiveOptions?
        get() = definedExternally
        set(value) = definedExternally
    var xAxis: XAxisOptions?
        get() = definedExternally
        set(value) = definedExternally
    var yAxis: YAxisOptions?
        get() = definedExternally
        set(value) = definedExternally
    var series: Array<Series>?
        get() = definedExternally
        set(value) = definedExternally
}
