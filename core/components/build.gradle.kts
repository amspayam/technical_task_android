plugins {
    id(Plugins.library)
    id(Plugins.sliidePlugin)
}

dependencies {
    // AndroidXView
    api(Dependencies.appcompat)
    api(Dependencies.cardView)
    api(Dependencies.constraintLayout)
    api(Dependencies.lifecycle)
    api(Dependencies.material)
    api(Dependencies.recyclerView)
    api(Dependencies.swipeRefresh)

    // Navigation
    api(Dependencies.navigationRuntime)
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUI)

    // Coroutines
    api(Dependencies.coroutinesCore)
    api(Dependencies.coroutinesAndroid)
}