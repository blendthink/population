@file:Suppress("OPT_IN_USAGE")

package dev.blendthink.population.data.response.result

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

typealias PrefectureResult = List<Prefecture>

@Serializable
data class Prefecture(
    @JsonNames("prefCode")
    val code: Int,
    @JsonNames("prefName")
    val name: String,
)
