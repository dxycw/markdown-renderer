<h1 align="center">Multiplatform-Markdown-Renderer</h1>

<p align="center">
    将 Markdown 渲染成原生 Compose UI —— 一个 API，适用于所有平台。
</p>

<p align="center">
    <a href="https://github.com/mikepenz/multiplatform-markdown-renderer/actions"><img src="https://github.com/mikepenz/multiplatform-markdown-renderer/workflows/CI/badge.svg" alt="CI status"></a>
    <a href="https://central.sonatype.com/artifact/com.mikepenz/multiplatform-markdown-renderer"><img src="https://img.shields.io/maven-central/v/com.mikepenz/multiplatform-markdown-renderer?style=flat-square&color=%231B4897" alt="Maven Central version"></a>
    <a href="https://scorecard.dev/viewer/?uri=github.com/mikepenz/multiplatform-markdown-renderer"><img src="https://img.shields.io/ossf-scorecard/github.com/mikepenz/multiplatform-markdown-renderer?style=flat-square&label=scorecard" alt="OpenSSF Scorecard"></a>
    <a href="https://github.com/mikepenz/multiplatform-markdown-renderer/blob/develop/LICENSE"><img src="https://img.shields.io/badge/license-Apache%202.0-blue?style=flat-square" alt="Apache 2.0 license"></a>
</p>

<p align="center">
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/mikepenz/multiplatform-markdown-renderer/develop/art/hero-dark.svg">
        <img src="https://raw.githubusercontent.com/mikepenz/multiplatform-markdown-renderer/develop/art/hero-light.svg" width="100%" alt="A markdown String is parsed by JetBrains Markdown into an AST, mapped through overridable MarkdownComponents, and rendered as Compose Multiplatform UI on Android, iOS, Desktop, Web and macOS.">
    </picture>
</p>

<p align="center">
    <a href="#quickstart">Quickstart</a> &bull;
    <a href="#showcase">Showcase</a> &bull;
    <a href="#reference">Reference</a> &bull;
    <a href="https://github.com/mikepenz/multiplatform-markdown-renderer/blob/develop/MIGRATION.md">Migration</a> &bull;
    <a href="https://github.com/mikepenz/multiplatform-markdown-renderer/blob/develop/CHANGELOG.md">Changelog</a>
</p>

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
dependencies {
    implementation("com.mikepenz:multiplatform-markdown-renderer:0.43.0")
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

    [Check out this link](https://github.com/mikepenz/multiplatform-markdown-renderer)
    """.trimIndent()
)
```

**3 — 对任何复杂的内容都提升解析。** `rememberMarkdownState` 是异步解析的，并且在重新组合时仍然存在：

```kotlin
val markdownState = rememberMarkdownState(markdown)
Markdown(markdownState)
```

完整配置——自定义组件、图片加载、语法高亮、扩展跨度——请见下面的[参考](#参考)。

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
