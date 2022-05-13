// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(ClassPaths.buildTools)
        classpath(ClassPaths.kotlin)
        classpath(ClassPaths.hilt)
        classpath(ClassPaths.ktLint)
        classpath(ClassPaths.navigation)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean").configure {
    delete("build")
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
            "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
        )
    }
}