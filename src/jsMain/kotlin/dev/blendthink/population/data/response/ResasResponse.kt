package dev.blendthink.population.data.response

import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import kotlinx.serialization.Serializable

@Serializable
data class ResasResponse<T>(
    val message: String? = null,
    val result: T,
)

@Serializable
data class ResasErrorResponse(
    val statusCode: Int,
)

class ResasForbiddenException(
    response: HttpResponse,
    cachedResponseText: String,
) : ResponseException(response, cachedResponseText)
