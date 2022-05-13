package com.sliie.components.extension.context

import android.content.Context

fun Context.getVersionApplication(): String? {
    return this.packageManager.getPackageInfo(
        this.packageName,
        0
    ).versionName
}