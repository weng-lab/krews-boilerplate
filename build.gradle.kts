import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.21"
    id("application")
    id("com.github.johnrengelman.shadow") version "4.0.2"
}

group = "krews.io"
version = "1.0.0"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.krews", "krews", "0.7.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "AppKt"
}

val shadowJar: ShadowJar by tasks
shadowJar.apply {
    classifier = "exec"
    destinationDir = file("build")
}