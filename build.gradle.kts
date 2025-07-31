plugins {
    id("java")
    kotlin("jvm")

    id("fabric-loom") version "1.9-SNAPSHOT"
    id("legacy-looming") version "1.9-SNAPSHOT"
    id("maven-publish")
}

group = properties["maven_group"].toString()
version = properties["mod_version"].toString()

val minecraft_version = properties["minecraft_version"].toString()
val yarn_build = properties["yarn_build"].toString()
val loader_version = properties["loader_version"].toString()
val fabric_version = properties["fabric_version"].toString()

repositories {
    mavenCentral()
}

dependencies {
    "minecraft" ("com.mojang:minecraft:${minecraft_version}")
    "mappings"("net.legacyfabric:yarn:1.8.9+build.$yarn_build:v2")
    "modImplementation" ("net.fabricmc:fabric-loader:${loader_version}")

    "modImplementation" ("net.legacyfabric.legacy-fabric-api:legacy-fabric-api:${fabric_version}")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"

    if(JavaVersion.current().isJava9Compatible) {
        options.release = 17
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
}