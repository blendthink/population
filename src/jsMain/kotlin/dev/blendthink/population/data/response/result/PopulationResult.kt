@file:Suppress("OPT_IN_USAGE")

package dev.blendthink.population.data.response.result

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * @param boundaryYear 実績値と推計値の区切り年
 */
@Serializable
data class PopulationResult(
    val boundaryYear: Int,
    @JsonNames("data")
    val itemList: List<PopulationItem>,
)

/**
 * @param label ラベル（総人口・年少人口・生産年齢人口・老年人口）
 */
@Serializable
data class PopulationItem(
    val label: String,
    @JsonNames("data")
    val dataList: List<PopulationData>
)

/**
 * @param year 年
 * @param value 人口
 * @param rate 割合（総人口の場合は存在しない）
 */
@Serializable
data class PopulationData(
    val year: Int,
    val value: Int,
    val rate: Double? = null,
)
