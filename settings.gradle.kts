pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://repo.legacyfabric.net/repository/legacyfabric/")
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "2.2.0"
    }
}

rootProject.name = "BridgeBase"

include(":Bridge")
include(":Client")
include(":v1_8_9")
include(":v1_21_4")