import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("java")
    kotlin("jvm")

    id("fabric-loom") version "1.9-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "gg.solar"
version = "1.0.0"

val minecraft_version = properties["minecraft_version"].toString()
val yarn_mappings = properties["yarn_mappings"].toString()
val loader_version = properties["loader_version"].toString()
val fabric_version = properties["fabric_version"].toString()

val shadowImplementation by configurations.creating

val shadowAdd by configurations.creating

fun DependencyHandler.shadowImplementation(dependencyNotation: Any): Dependency? {
    add("implementation", dependencyNotation)
    return add("shadowImplementation", dependencyNotation)
}

fun DependencyHandler.shadow(dep: Any): Dependency? = add("shadow", dep)

repositories {
    mavenCentral()
}

dependencies {
    // To change the versions see the gradle.properties file
    "minecraft" ("com.mojang:minecraft:${minecraft_version}")
    "mappings" ("net.fabricmc:yarn:${yarn_mappings}:v2")
    "modImplementation" ("net.fabricmc:fabric-loader:${loader_version}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    "modImplementation" ("net.fabricmc.fabric-api:fabric-api:${fabric_version}")

    shadowImplementation(project(":Bridge"))
    shadowImplementation(project(":Client"))
}

tasks.named<ShadowJar>("shadowJar") {
    archiveClassifier.set("dev-shadow")
    configurations = listOf(shadowImplementation, shadowAdd)
    exclude("org/lwjgl/**")
    dependsOn("classes")
}

tasks.named<RemapJarTask>("remapJar") {
    dependsOn("shadowJar")
    input.set(tasks.named<ShadowJar>("shadowJar").flatMap { it.archiveFile })
    archiveClassifier.set("")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"

    if(JavaVersion.current().isJava9Compatible) {
        options.release = 21
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    withSourcesJar()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}