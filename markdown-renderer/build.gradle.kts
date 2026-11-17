import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    id("com.vanniktech.maven.publish") version "0.37.0" // 使用最新稳定版
}

kotlin {

    android {
        namespace = "com.mikepenz.markdown"
        compileSdk {
            version = release(37){
                minorApiLevel = 1 // 指定次要 API 级别为 1，即 37.1
            }
        }
        minSdk = 24

        // 从 Android Gradle 插件版本 8.8.0 开始
        // 必须显式开启，否则 androidMain/res 被忽略
        androidResources {
            enable = true
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    listOf(
//        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "markdown-rendererKit"
            isStatic = true
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                compileOnly(libs.kotlin.stdlib)
                // Add KMP dependencies here

                compileOnly(libs.compose.runtime)
                compileOnly(libs.compose.foundation)
                compileOnly(libs.compose.material)
                compileOnly(libs.compose.material3)
                compileOnly(libs.compose.ui)
                compileOnly(libs.compose.components.resources)
                compileOnly(libs.compose.uiToolingPreview)
                compileOnly(libs.androidx.lifecycle.viewmodelCompose)
                compileOnly(libs.androidx.lifecycle.runtimeCompose)

                api(libs.markdown)
                api(libs.highlights)

                implementation(libs.kotlinx.collections.immutable)

                implementation(libs.coil3.core)

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                compileOnly(libs.coil2.core)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
                implementation(libs.androidx.testRunner)
            }
        }

        getByName("desktopMain")  {
            dependencies {
            }
        }

        iosMain {
            dependencies {
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }

        jsMain {
            dependencies {
//                implementation(libs.wrappers.browser)

                // Compose Markdown Multiplatform
//                implementation("io.ktor:ktor-client-js-js:3.6.0")
            }
        }

        wasmJsMain {
            dependencies {
                // Compose Markdown Multiplatform
//                implementation("io.ktor:ktor-client-js-wasm-js:3.6.0")
            }
        }

    }

}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}

mavenPublishing {
    // 指向 Central Portal（不是旧的 OSSRH）
    publishToMavenCentral()

    // 自动签名所有 publication
    signAllPublications()

    coordinates(
        groupId = "io.github.dxycw",
        artifactId = "markdown-renderer",
        version = "1.0.0" // 从 gradle.properties 或版本目录读取更佳
    )

    pom {
        name.set("markdown")
        description.set("用于Kotlin多平台项目（Android、iOS、Desktop (Windows, MacOS 和 Linux)和 Web 的Markdown包，使用Jetpack Compose Multiplatform开发。 注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。")
        url.set("https://github.com/dxycw/markdown")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("dxycw")
                name.set("markdown")
                email.set("3293666408@qq.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/dxycw/markdown.git")
            developerConnection.set("scm:git:ssh://github.com/dxycw/markdown.git")
            url.set("https://github.com/dxycw/markdown")
        }
    }
}