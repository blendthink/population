@file:Suppress("unused")

package dev.blendthink.population.ui.style

import dev.blendthink.population.ui.util.TextTransform
import dev.blendthink.population.ui.util.textTransform
import org.jetbrains.compose.web.css.*

object TextStyle : StyleSheet() {

    val headline1 by style {
        fontFamily("Robot")
        fontWeight("lighter")
        fontSize(96.px)
        letterSpacing((-1.5).px)
    }

    val headline2 by style {
        fontFamily("Robot")
        fontWeight("lighter")
        fontSize(60.px)
        letterSpacing((-0.5).px)
    }

    val headline3 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(48.px)
        letterSpacing(0.px)
    }

    val headline4 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(34.px)
        letterSpacing(0.25.px)
    }

    val headline5 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(24.px)
        letterSpacing(0.px)
    }

    val headline6 by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(20.px)
        letterSpacing(0.15.px)
    }

    val subtitle1 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(16.px)
        letterSpacing(0.15.px)
    }

    val subtitle2 by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(14.px)
        letterSpacing(0.1.px)
    }

    val body1 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(16.px)
        letterSpacing(0.5.px)
    }

    val body2 by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(14.px)
        letterSpacing(0.25.px)
    }

    val button by style {
        fontFamily("Robot")
        fontWeight(500)
        fontSize(14.px)
        letterSpacing(1.25.px)
        textTransform(TextTransform.UPPERCASE)
    }

    val caption by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(12.px)
        letterSpacing(0.4.px)
    }

    val overline by style {
        fontFamily("Robot")
        fontWeight("normal")
        fontSize(10.px)
        letterSpacing(1.5.px)
        textTransform(TextTransform.UPPERCASE)
    }
}
