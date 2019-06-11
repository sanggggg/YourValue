package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class GarakAuctionRslt (
    @field:Json(name = "list_total_count") val list_total_count: Int,
    @field:Json(name = "RESULT") val result: RESULT,
    @field:Json(name = "row") val row: List<Squid>
)