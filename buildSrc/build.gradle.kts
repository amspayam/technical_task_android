plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
}

gradlePlugin {
    val packageName = "com.sliide"
    plugins {
        register("sliide.plugin") {
            id = "sliide.plugin"
            implementationClass = "$packageName.SliidePlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
}