package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class NestedResponse (
    @field:Json(name = "GarakAuctionRslt") val garakAuctionRslt: GarakAuctionRslt
)