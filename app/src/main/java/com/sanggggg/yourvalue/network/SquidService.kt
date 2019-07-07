package com.sanggggg.yourvalue.network

import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.model.NestedResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface SquidService {
    /*
    @GET("/{ADJ_DT}")
    fun fetchSquid(@Path("ADJ_DT")ADJ_DT : String): Observable<NestedResponse>*/

    @GET("{ADJ_DT}")
    fun fetchSquid(@Path("ADJ_DT")ADJ_DT : String): Observable<NestedResponse>
}