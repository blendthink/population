package dev.blendthink.population.di

import dev.blendthink.population.data.repository.PopulationRepository
import dev.blendthink.population.data.repository.PopulationRepositoryImpl
import dev.blendthink.population.data.repository.PrefectureRepository
import dev.blendthink.population.data.repository.PrefectureRepositoryImpl
import dev.blendthink.population.ui.content.MainContentNotifier
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.MainScope
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

class ModuleGenerator(
    private val apiKey: String,
) {
    fun appModules(): List<Module> {
        val clientModule = module {
            single {
                HttpClient(Js) {
                    defaultRequest {
                        url {
                            protocol = URLProtocol.HTTPS
                            host = "opendata.resas-portal.go.jp"
                            path("api/v1/")
                        }
                        header("X-API-KEY", apiKey)
                    }
                    install(ContentNegotiation) {
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                    install(Logging) {
                        logger = Logger.SIMPLE
                        level = LogLevel.ALL
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
            factory { MainContentNotifier(get(), get(), MainScope()) }
        }

        return listOf(clientModule, repositoryModule, notifierModule)
    }
}
