plugins {
    java
    kotlin("jvm") version "2.2.20"
}
sourceSets.main{ java.srcDir("src") }
version = "1.0"
description = "Snake Game"
repositories { mavenCentral() }
dependencies {
    compileOnly("org.jetbrains:annotations:24.1.0")
    implementation("com.badlogicgames.gdx:gdx:1.12.1")
    implementation(kotlin("stdlib", "2.2.20"))
}
tasks.register("deploy") {
    doFirst {
        tasks.jar { manifest.attributes(
            "Main-Class" to "snake.PreparationLoader",
            "Implementation-Title" to "snake"
        )}
    }
    dependsOn(tasks.jar)
    doLast {
        print("Deploying!\n")
    }
}