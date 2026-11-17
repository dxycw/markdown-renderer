package com.mikepenz.markdown.sample

import androidx.compose.runtime.Composable
import com.mikepenz.aboutlibraries.ui.compose.produceLibraries
import markdownrenderercs.app.shared.generated.resources.Res

@Composable
fun aboutlibraries() = produceLibraries {
    Res.readBytes("files/aboutlibraries.json").decodeToString()
}
