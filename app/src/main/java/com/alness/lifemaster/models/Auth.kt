package com.alness.lifemaster.models

import kotlinx.serialization.Serializable

@Serializable
data class Auth(
    var username: String,
    var password: String
)
