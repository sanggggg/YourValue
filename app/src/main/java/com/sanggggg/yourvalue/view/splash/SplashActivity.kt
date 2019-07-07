package com.sanggggg.yourvalue.view.splash

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.getToday
import com.sanggggg.yourvalue.model.Squid
import com.sanggggg.yourvalue.network.SquidService
import com.sanggggg.yourvalue.view.intro.IntroActivity
import com.sanggggg.yourvalue.view.main.MainActivity
import com.squareup.moshi.JsonAdapter
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var api : SquidService

    @Inject
    lateinit var preference : SharedPreferences

    @Inject
    lateinit var squidAdapter : JsonAdapter<Squid>

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        compositeDisposable.add(api.fetchSquid(getToday())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.i(it.toString())
                preference.edit().putString("squid_today_price", it.garakAuctionRslt.row[0].pprice.toString()).commit()
                preference.edit().putString("squid_today_uun", it.garakAuctionRslt.row[0].uun).commit()
                startActivity(IntroActivity.createIntent(this))
                finish()
            }, {
                Timber.i(it.toString() + "whattt?")
                Toast.makeText(this, "서버 상태가 불안정합니다.", Toast.LENGTH_SHORT).show()
                finish()
            }))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}