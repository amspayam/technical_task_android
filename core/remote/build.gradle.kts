plugins {
    id(Plugins.library)
    id(Plugins.sliidePlugin)
}

dependencies {
    implementation(project(Modules.baseModule))

    // Retrofit
    api(Dependencies.retrofit)
    api(Dependencies.converter)
    api(Dependencies.interceptor)

    // Coroutines
    api(Dependencies.coroutinesCore)
    api(Dependencies.coroutinesAndroid)

}