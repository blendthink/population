package dev.blendthink.population.data.repository

import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.response.ResasResponse
import dev.blendthink.population.data.response.result.PrefectureResult
import dev.blendthink.population.data.converter.convertResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PrefectureRepository {
    /**
     * 都道府県データを返す
     */
    suspend fun getPrefectures(): Result<ResasResponse<PrefectureResult>>
}

class PrefectureRepositoryImpl(
    private val client: HttpClient,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
) : PrefectureRepository {
    override suspend fun getPrefectures(): Result<ResasResponse<PrefectureResult>> =
        withContext(defaultDispatcher) {
            convertResponse {
                client.get("prefectures").body()
            }
        }
}
