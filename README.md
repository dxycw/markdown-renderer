> [!CAUTION]
>
> **注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。**

<div align="center">

<h1 align="center">Markdown-Renderer</h1>

<p align="center">
    将 Markdown 渲染成原生 Compose UI —— 一个 API，适用于所有平台。
</p>

[![Maven Central](https://img.shields.io/maven-central/v/io.github.dxycw/markdown-renderer?label=Maven%20Central&color=orange)](https://central.sonatype.com/artifact/io.github.dxycw/markdown-renderer)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.4.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.12.2-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>


|                             |                                                                                           |
|-----------------------------|-------------------------------------------------------------------------------------------|
| 🧩 **每个平台**             | 通过一个 `commonMain` 调用即可覆盖 Android、iOS、桌面（JVM）、网页（Wasm / JS）和 macOS。 |
| ⚡ **默认异步**             | `rememberMarkdownState` 会解析组合；`retainState = true` 会在重新解析时保持内容可见。     |
| 🎨 **Material 2 和 3**      | `-m2` / `-m3` 的主题默认值；可通过 `markdownColor()` 和 `markdownTypography()` 覆盖。     |
| 🧱 **每个元素都可以被重写** | `MarkdownComponents` 将每个 AST 节点映射到你控制的 `@Composable`。                        |
| 📊 **完整 GFM**             | 表格、任务列表、删除线、自动链接和 GitHub 提示，开箱即用。                                |
| 📡 **为流媒体而生**         | `rememberStreamingMarkdownState()` 会追加数据块并只重新解析不稳定的尾部。                 |

## 快速入门

**1 — 添加依赖。** 选择与你的 Material 主题匹配的模块：

```kotlin

// 在项目的 build.gradle.kts 文件中添加依赖项
kotlin {
    sourceSets {
        // 多平台，
        commonMain.dependencies {
            // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
            implementation("io.github.dxycw:markdown-renderer:1.0.0")
        }
    }
}

```

**2 — 渲染。** 从 `com.mikepenz.markdown.m3`（或 `.m2`）导入 `Markdown`：

```kotlin
import com.mikepenz.markdown.m3.Markdown

Markdown(
    """
    # Hello Markdown

    - Bullet points
    - **Bold** and *italic* text

    [Check out this link](https://github.com/dxycw/markdown-renderer)
    """.trimIndent()
)
```

**3 — 对任何复杂的内容都提升解析。** `rememberMarkdownState` 是异步解析的，并且在重新组合时仍然存在：

```kotlin
val markdownState = rememberMarkdownState(markdown)
Markdown(markdownState)
```

-------

### 包含什么 🚀

- **跨平台 Markdown 渲染** - 支持 Android、iOS、桌面和 Web
- **Material 设计集成** - 与 Material 2 和 Material 3 主题无缝集成
- **丰富的 Markdown 支持** - 可以渲染标题、列表、代码块、表格、图片等
- **语法高亮** - 可选的多种编程语言代码语法高亮
- **图片加载** - 灵活的图片加载，支持 Coil2 和 Coil3 集成
- **自定义选项** - 可广泛自定义颜色、字体、组件等
- **性能优化** - 高效渲染，支持大文档的懒加载
- **扩展文本跨度** - 支持高级文本样式的扩展跨度
- **轻量化** - 依赖少，性能优化

-------

## 依赖

这个库使用了以下主要依赖:

- [JetBrains Markdown](https://github.com/JetBrains/markdown/) - 多平台 Markdown 处理器，用于解析 Markdown 内容
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) - 用于跨平台的界面渲染
- [Extended Spans](https://github.com/saket/extended-spans) - 用于高级文本样式（作为多平台集成）
- [Highlights](https://github.com/SnipMeDev/Highlights) - 用于代码语法高亮（可选）

## 更新日志

### 1.0.0

* 发布到 Maven Central 仓库；
* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 把“multiplatform-markdown-renderer”0.46.0版本的所有库导入到“markdown-renderer”中；
* 添加 Multiplatform平台的 org.jetbrains:markdown 依赖库版本为 0.7.18；
* 添加 Multiplatform平台的 dev.snipme:highlights 依赖库版本为 1.2.0；

## License

    Copyright 2026 Mike Penz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
