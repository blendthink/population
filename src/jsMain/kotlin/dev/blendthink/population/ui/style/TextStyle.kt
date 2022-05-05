@file:Suppress("unused")

package dev.blendthink.population.ui.style

import dev.blendthink.population.ui.util.TextTransform
import dev.blendthink.population.ui.util.textTransform
import org.jetbrains.compose.web.css.*

object TextStyle : StyleSheet() {

    val headline1 by style {
        fontFamily("Robot")
        fontWeight("lighter")
        fontSize(6.cssRem)
        letterSpacing((-0.009375).cssRem)
    }

    val headline2 by style {
        fontFamily("Robot")
        fontWeight("lighter")
        fontSize(3.75.cssRem)
        letterSpacing((-0.03125).cssRem)
    }

    val headline3 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(3.cssRem)
        letterSpacing(0.cssRem)
    }

    val headline4 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(2.125.cssRem)
        letterSpacing(0.015625.cssRem)
    }

    val headline5 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(1.5.cssRem)
        letterSpacing(0.cssRem)
    }

    val headline6 by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(1.25.cssRem)
        letterSpacing(0.009375.cssRem)
    }

    val subtitle1 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(1.cssRem)
        letterSpacing(0.009375.cssRem)
    }

    val subtitle2 by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(0.875.cssRem)
        letterSpacing(0.00625.cssRem)
    }

    val body1 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(1.cssRem)
        letterSpacing(0.03125.cssRem)
    }

    val body2 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(1.5.cssRem)
        letterSpacing(0.015625.cssRem)
    }

    val button by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(0.875.cssRem)
        letterSpacing(0.078125.cssRem)
        textTransform(TextTransform.UPPERCASE)
    }

    val caption by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(0.75.cssRem)
        letterSpacing(0.025.cssRem)
    }

    val overline by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(0.625.cssRem)
        letterSpacing(0.09375.cssRem)
        textTransform(TextTransform.UPPERCASE)
    }
}
