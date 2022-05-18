package dev.blendthink.population.di

import dev.blendthink.population.data.repository.PopulationRepository
import dev.blendthink.population.data.repository.PopulationRepositoryImpl
import dev.blendthink.population.data.repository.PrefectureRepository
import dev.blendthink.population.data.repository.PrefectureRepositoryImpl
import dev.blendthink.population.data.response.ResasErrorResponse
import dev.blendthink.population.data.response.ResasForbiddenException
import dev.blendthink.population.ui.content.MainContentNotifier
import dev.blendthink.population.ui.content.graph.GraphContentNotifier
import dev.blendthink.population.ui.util.Environment
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

class ModuleGenerator(
    private val apiKey: String,
) {
    fun appModules(): List<Module> {
        val clientModule = module {
            single {
                val json = Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
                HttpClient(Js) {
                    defaultRequest {
                        url {
                            protocol = URLProtocol.HTTPS
                            host = "opendata.resas-portal.go.jp"
                            path("api/v1/")
                        }
                        header("X-API-KEY", apiKey)
                    }
                    install(SavedCall)
                    install(ContentNegotiation) {
                        json(json)
                    }
                    HttpResponseValidator {
                        validateResponse { response ->
                            val exceptionResponseText = response.bodyAsText()
                            runCatching {
                                json.decodeFromString(ResasErrorResponse.serializer(), exceptionResponseText)
                            }.onSuccess {
                                if (it.statusCode == 403) {
                                    throw ResasForbiddenException(response, exceptionResponseText)
                                } else {
                                    throw ResponseException(response, exceptionResponseText)
                                }
                            }.onFailure {
                                // No action is taken to proceed to normal processing.
                            }
                        }
                    }
                    if (Environment.isDevelopment) {
                        install(Logging) {
                            logger = Logger.SIMPLE
                            level = LogLevel.ALL
                        }
                    }
                    expectSuccess = true
                }
            }
        }

        val repositoryModule = module {
            single<PrefectureRepository> { PrefectureRepositoryImpl(get()) }
            single<PopulationRepository> { PopulationRepositoryImpl(get()) }
        }

        val notifierModule = module {
            factory { MainContentNotifier(get()) }
            factory { GraphContentNotifier(get()) }
        }

        return listOf(clientModule, repositoryModule, notifierModule)
    }
}

/**
 * https://youtrack.jetbrains.com/issue/KTOR-4002
 */
class SavedCall {
    companion object : HttpClientPlugin<Unit, SavedCall> {
        private val saveAttributeKey = AttributeKey<Unit>("BodySaved")

        override val key: AttributeKey<SavedCall> = AttributeKey("SavedCall")

        override fun install(plugin: SavedCall, scope: HttpClient) {
            scope.plugin(HttpSend).intercept { request ->
                val call = execute(request)
                if (call.attributes.contains(saveAttributeKey)) {
                    call
                } else {
                    val newCall = call.save()
                    newCall.attributes.put(saveAttributeKey, Unit)
                    newCall
                }
            }
        }

        override fun prepare(block: Unit.() -> Unit): SavedCall {
            return SavedCall()
        }
    }
}
