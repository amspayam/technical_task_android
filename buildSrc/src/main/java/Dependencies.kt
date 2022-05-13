object Dependencies {

    // views
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycle =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val recyclerView =
        "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"

    // navigation
    const val navigationRuntime =
        "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"

    // testing
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testAndroidxCore = "androidx.test:core:${Versions.androidxTest}"
    const val testAndroidxRules = "androidx.test:rules:${Versions.androidxTest}"
    const val testAndroidxRunner = "androidx.test:runner:${Versions.androidxTest}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"

    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

}
