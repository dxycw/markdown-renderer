package com.dxyc.markdown.renderer

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mikepenz.markdown.sample.App
import com.mikepenz.markdown.sample.aboutlibraries

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Markdownrenderercs",
    ) {
        val libraries by aboutlibraries()
        App(libraries = libraries)
    }
}