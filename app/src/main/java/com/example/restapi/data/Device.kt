package com.example.restapi.data

import kotlinx.serialization.Serializable

@Serializable

data class Device(
    val id: String,
    val name: String,
    val data: Map<String, Any>
)