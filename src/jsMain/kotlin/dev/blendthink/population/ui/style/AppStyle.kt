package dev.blendthink.population.ui.style

import dev.blendthink.population.ui.extension.Float
import dev.blendthink.population.ui.extension.float
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

object AppStyle : StyleSheet() {
    /**
     * for fixing footer at the bottom
     */
    init {
        type("html,body") style {
            height(100.vh)
        }

        type("body") style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
        }

        type("code") style {
            display(DisplayStyle.InlineBlock)
            padding(0.1.em, 0.25.em, 0.1.em, 0.25.em)
            color(Color("#444"))
            backgroundColor(Color("#e7edf3"))
            borderRadius(4.px)
            border {
                width = 1.px
                style = LineStyle.Solid
                color = Color("#d6dde4")
            }
        }
    }

    val main by style {
        width(100.vw)
        flex(1)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
    }

    val footer by style {
        width(100.vw)
        padding(1.cssRem, 0.cssRem, 1.cssRem, 0.cssRem)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
    }

    val error by style {
        padding(1.cssRem)
        justifyContent(JustifyContent.Center)
    }

    val prefCheckboxes by style {
        padding(1.cssRem)
        display(DisplayStyle.Grid)
        gridTemplateColumns("repeat(auto-fit, minmax(5rem, 1fr))")
        gap(0.5.cssRem)
    }

    val prefCheckbox by style {
        display(DisplayStyle.Block)

        type("label") style {
            cursor("pointer")
            width(100.percent)
            display(DisplayStyle.Block)
            float(Float.LEFT)
            padding(0.4.cssRem, 0.6.cssRem, 0.4.cssRem, 0.6.cssRem)
            border {
                width = 1.px
                style = LineStyle.Solid
                color = Color.gainsboro
            }
            borderRadius(10.px)
            textAlign("center")
            property("transition", "background-color .5s")
        }

        type("label:hover") style {
            backgroundColor(Color.whitesmoke)
        }

        type("input") style {
            display(DisplayStyle.None)
        }

        type("input:checked + label") style {
            backgroundColor(Color.gainsboro)
        }
    }

    @Suppress("OPT_IN_IS_NOT_ENABLED")
    @OptIn(ExperimentalComposeWebApi::class)
    private val scaleOutKeyFrame by keyframes {
        from {
            transform { scale(0) }
        }
        to {
            transform { scale(1.0) }
            opacity(0)
        }
    }

    val loading by style {
        width(5.cssRem)
        height(5.cssRem)
        backgroundColor(Color.blue)
        borderRadius(100.percent)
        animation(scaleOutKeyFrame) {
            duration(1.s)
            iterationCount(Int.MAX_VALUE)
            timingFunction(AnimationTimingFunction.EaseInOut)
        }
    }

    val graphContent by style {
        width(90.vw)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)
        paddingTop(1.cssRem)
    }

    val graph by style {}
}
