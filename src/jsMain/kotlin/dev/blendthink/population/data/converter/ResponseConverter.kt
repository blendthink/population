package dev.blendthink.population.data.converter

import io.ktor.client.plugins.*
import kotlinx.serialization.SerializationException

inline fun <T, R> T.convertResponse(block: T.() -> R): Result<R> {
    return try {
        Result.Success(block())
    } catch (e: ResponseException) {
        Result.Error(e)
    } catch (e: SerializationException) {
        Result.Error(e)
    }
}

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
