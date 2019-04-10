package com.sanggggg.yourvalue.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.network.SquidService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiKey = "5a7a756c556b736d3635796d68564d"

        val retrofit = Retrofit.Builder()
            .baseUrl("http://openapi.seoul.go.kr:8088/$apiKey/json/GarakGradePrice/1/5/%EB%AC%BC%EC%98%A4%EC%A7%95%EC%96%B4/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val service = retrofit.create(SquidService::class.java)

        text_view.setText("what happened?")
        val disposable = service.fetchSquid()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                text_view.setText("adf")
                Log.d("___Successe", it.garakGradePrice.list_total_count.toString())
            }, {
                text_view.setText("Failed!")
                Log.d("___Failed", it.message)
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()

    }
}
