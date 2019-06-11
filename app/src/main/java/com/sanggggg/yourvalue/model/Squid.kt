package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class Squid(
    @field:Json(name = "PUM_NAME") val pum_name: String,
    @field:Json(name = "UUN") val uun: String,
    @field:Json(name = "DDD") val ddd: String,
    @field:Json(name = "PPRICE") val pprice: Double,
    @field:Json(name = "SSANGI") val ssangi: String,
    @field:Json(name = "INJUNG_GUBUN") val injung_gubun: String,
    @field:Json(name = "ADJ_DT") val adj_dt: String

)