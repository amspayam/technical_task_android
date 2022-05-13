plugins {
    id(Plugins.library)
    id(Plugins.sliidePlugin)
}

dependencies {
    implementation(project(Modules.baseModule))
    implementation(project(Modules.componentsModule))
    implementation(project(Modules.navigationModule))
    implementation(project(Modules.remoteModule))
}