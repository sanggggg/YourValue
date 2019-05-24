package com.sanggggg.yourvalue.view.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.network.SquidService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiURL = R.string.api_URL.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl(apiURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val service = retrofit.create(SquidService::class.java)

        text_view.setText("what happened?")
        val disposable = service.fetchSquid()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                text_view.setText("오늘의 오징어 평균가는 무려 6kg에 "+ it.garakGradePrice.row.get(2).avgPrice.toString() + "원이다...\n 따라서 오늘 당신의 가치는 433333.333원이다....")
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
