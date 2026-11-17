package com.dxyc.markdown.renderer

import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.mikepenz.markdown.sample.App
import com.mikepenz.markdown.sample.aboutlibraries

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        WithFontResourcesLoaded {
//            App()
            val libraries by aboutlibraries()
            App(libraries)
        }
    }
}