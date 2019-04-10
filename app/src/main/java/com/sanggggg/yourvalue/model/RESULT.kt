package com.sanggggg.yourvalue.model

import com.squareup.moshi.Json

data class RESULT(
    @field:Json(name = "CODE") val CODE : String,
    @field:Json(name = "MESSAGE") val MESSAGE : String
)
