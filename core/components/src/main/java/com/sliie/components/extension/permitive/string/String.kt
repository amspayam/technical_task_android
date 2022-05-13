package com.sliie.components.extension.permitive.string

import java.util.*

fun String.pascalCase() = split(" ").joinToString(" ") { it.capitalize(Locale.ROOT) }