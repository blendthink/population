@file:Suppress("unused")

package dev.blendthink.population.ui.extension

import org.jetbrains.compose.web.css.StyleScope

// https://developer.mozilla.org/en-US/docs/Web/CSS/text-transform
fun StyleScope.textTransform(transform: TextTransform) {
    property("text-transform", transform.value)
}

enum class TextTransform(val value: String) {
    CAPITALIZE("capitalize"),
    UPPERCASE("uppercase"),
    LOWERCASE("lowercase"),
    NONE("none"),
    FULL_WIDTH("full-width"),
    FULL_SIZE_KANA("full-size-kana"),
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/float
fun StyleScope.float(float: Float) {
    property("float", float.value)
}

enum class Float(val value: String) {
    NONE("none"),
    LEFT("left"),
    RIGHT("right"),
}
