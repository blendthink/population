package dev.blendthink.population.ui.util

import kotlinx.browser.window

object Environment {
    val isDevelopment
        get() = window.location.hostname == "localhost"
}