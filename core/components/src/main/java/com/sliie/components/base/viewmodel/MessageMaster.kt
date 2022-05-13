package com.sliie.components.base.viewmodel

data class MessageMaster(
    val type: MessageTypeEnum,
    val message: String? = null,
    val messageResourceId: Int? = null,
    val viewId: Int? = null,
    var text: String = ""
)