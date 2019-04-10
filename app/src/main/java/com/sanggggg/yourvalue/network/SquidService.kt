package com.sanggggg.yourvalue.network

import com.sanggggg.yourvalue.model.GarakGradePrice
import com.sanggggg.yourvalue.model.NestedResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface SquidService {
    @GET("1/")
    fun fetchSquid(): Observable<NestedResponse>


}