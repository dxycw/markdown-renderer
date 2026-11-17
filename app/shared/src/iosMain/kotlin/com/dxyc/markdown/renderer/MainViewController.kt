package com.dxyc.markdown.renderer

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import com.mikepenz.markdown.sample.App
import com.mikepenz.markdown.sample.aboutlibraries

fun MainViewController() = ComposeUIViewController {
    val libraries by aboutlibraries()
    App(libraries = libraries)
}