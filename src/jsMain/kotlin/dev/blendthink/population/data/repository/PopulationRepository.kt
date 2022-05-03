package dev.blendthink.population.data.repository

import dev.blendthink.population.data.converter.Result
import dev.blendthink.population.data.converter.convertResponse
import dev.blendthink.population.data.response.ResasResponse
import dev.blendthink.population.data.response.result.PopulationResult
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PopulationRepository {
    /**
     * 地域単位、年単位の年齢構成のデータを返す
     * データ提供年：1980-2045年（5年毎）
     *
     * @param prefCode 都道府県コード
     */
    suspend fun getPopulation(prefCode: Int): Result<ResasResponse<PopulationResult>>
}

class PopulationRepositoryImpl(
    private val client: HttpClient,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
) : PopulationRepository {
    override suspend fun getPopulation(prefCode: Int): Result<ResasResponse<PopulationResult>> =
        withContext(defaultDispatcher) {
            convertResponse {
                client.get("population/composition/perYear") {
                    parameter("prefCode", prefCode)
                    parameter("cityCode", "-")
                }.body()
            }
        }
}
