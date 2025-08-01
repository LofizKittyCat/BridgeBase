plugins {
    id("java")
    kotlin("jvm")

    id("fabric-loom") version "1.9-SNAPSHOT" apply false
    id("maven-publish")

    id("io.freefair.lombok") version "8.14"
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

group = properties["maven_group"].toString()
version = properties["mod_version"].toString()

repositories {
    mavenCentral()
}