package com.sanggggg.yourvalue

import android.util.Log
import com.sanggggg.yourvalue.di.DaggerAppComponent
import com.sanggggg.yourvalue.network.SquidService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun asdf() {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.seoul.go.kr:8088/50446678776b736d3835417a6d6e61/json/GarakAuctionRslt/1/1/오징어수입/20190607/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        var service = retrofit.create(SquidService::class.java)
        service.fetchSquid()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("ASDF", it.garakAuctionRslt.row[1].pprice.toString())
            }, {
                Log.d("ASDF", it.message)
            })
    }
}
