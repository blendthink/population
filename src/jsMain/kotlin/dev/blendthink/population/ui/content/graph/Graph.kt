package dev.blendthink.population.ui.content.graph

import dev.blendthink.population.ui.style.AppStyle
import dev.blendthink.population.ui.util.*

object Graph {
    fun initialize() {
        Highcharts.setOptions(Options().apply {
            lang = LangOptions().apply {
                thousandsSep = ","
            }
        })

        val initialOptions = Options().apply {
            title = TitleOptions().apply {
                text = "都道府県の総人口推移"
            }
            xAxis = XAxisOptions().apply {
                title = XAxisTitleOptions().apply {
                    text = "年"
                    align = "high"
                    x = 10
                }
            }
            yAxis = YAxisOptions().apply {
                title = YAxisTitleOptions().apply {
                    text = "総人口"
                    align = "high"
                    rotation = 0
                    y = -10
                }
            }
            tooltip = TooltipOptions().apply {
                valueSuffix = "人"
            }
            legend = LegendOptions().apply {
                layout = "vertical"
                align = "right"
                verticalAlign = "middle"
                borderWidth = 0
            }
            responsive = ResponsiveOptions().apply {
                rules = arrayOf(
                    ResponsiveRulesOptions().apply {
                        condition = ResponsiveRulesConditionOptions().apply {
                            maxWidth = 600
                        }
                        chartOptions = Options().apply {
                            xAxis = XAxisOptions().apply {
                                title = XAxisTitleOptions().apply {
                                    align = "middle"
                                    x = 0
                                }
                            }
                            yAxis = YAxisOptions().apply {
                                title = YAxisTitleOptions().apply {
                                    align = "middle"
                                    rotation = 270
                                    y = 0
                                }
                            }
                            legend = LegendOptions().apply {
                                layout = "horizontal"
                                align = "center"
                                verticalAlign = "bottom"
                            }
                        }
                    }
                )
            }
        }
        Highcharts.chart(AppStyle.graph, initialOptions)
    }

    private fun findChart(): Chart? = Highcharts.charts.getOrNull(0)

    private fun findSeries(name: String): Series? = findChart()?.series?.find { it.name == name }

    fun addData(data: GraphData) {
        val chart = findChart() ?: return
        chart.addSeries(data.series)
    }

    fun removeData(data: GraphData) {
        val series = findSeries(data.prefecture.name) ?: return
        series.remove()
    }
}
