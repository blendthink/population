package dev.blendthink.population.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ResasResponse<T>(
    val message: String? = null,
    val result: T,
)
