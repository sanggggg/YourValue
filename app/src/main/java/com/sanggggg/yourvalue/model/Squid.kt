package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class Squid(
    @field:Json(name = "PUMNAME") val pumname: String,
    @field:Json(name = "GRADENAME") val gradename: String,
    @field:Json(name = "UNITQTY") val unitqty: String,
    @field:Json(name = "UNITNAME") val unitname: String,
    @field:Json(name = "MAXPRICE") val maxPrice: Double,
    @field:Json(name = "MINPRICE") val minPrice: Double,
    @field:Json(name = "AVGPRICE") val avgPrice: Double,
    @field:Json(name = "INVEST_DT") val investDt: String

)