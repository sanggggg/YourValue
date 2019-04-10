package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class NestedResponse (
    @field:Json(name = "GarakGradePrice") val garakGradePrice: GarakGradePrice
)