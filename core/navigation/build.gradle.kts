plugins {
    id(Plugins.library)
    id(Plugins.sliidePlugin)
}

dependencies {

    // Navigation
    api(Dependencies.navigationRuntime)
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUI)

}