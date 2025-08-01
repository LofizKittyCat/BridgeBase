import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask
import org.gradle.kotlin.dsl.named

plugins {
    id("java")
    kotlin("jvm")

    id("fabric-loom") version "1.9-SNAPSHOT"
    id("legacy-looming") version "1.9-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "gg.solar"
version = "1.0.0"

val minecraft_version = properties["minecraft_version"].toString()
val yarn_build = properties["yarn_build"].toString()
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
    "minecraft" ("com.mojang:minecraft:${minecraft_version}")
    "mappings"("net.legacyfabric:yarn:1.8.9+build.$yarn_build:v2")
    "modImplementation" ("net.fabricmc:fabric-loader:${loader_version}")

    "modImplementation" ("net.legacyfabric.legacy-fabric-api:legacy-fabric-api:${fabric_version}")

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
        options.release = 17
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}