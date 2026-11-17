@file:Suppress("UnstableApiUsage")

rootProject.name = "Markdownrenderercs"

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
//        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
    versionCatalogs {
        create("baseLibs") {
            from("com.mikepenz:version-catalog:0.23.2")
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":app:androidApp")
include(":app:desktopApp")
include(":app:shared")
include(":app:webApp")
include(":core")
include(":server")

include(":markdown-renderer")
