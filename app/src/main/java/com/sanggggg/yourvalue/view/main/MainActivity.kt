package com.sanggggg.yourvalue.view.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanggggg.yourvalue.*
import com.sanggggg.yourvalue.network.SquidService
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import kotlin.math.roundToInt

class MainActivity : DaggerAppCompatActivity() {
    companion object {
        fun createIntent(context : Context) : Intent = Intent(context, MainActivity::class.java)

    }
    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var api: SquidService

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userWeight : Double
        var pricePerKg : Double
        var yourValue : String

        userWeight = preferences.getInt("user_weight", 0).toDouble()
        pricePerKg = preferences.getString("squid_today_price", "0").toDouble() / getWeight(preferences.getString("squid_today_uun", "0kg"))
        yourValue = getFormattedWon(userWeight * pricePerKg)

        Timber.i("______^$userWeight $pricePerKg")

        text_main_date.setText(getFormattedDate(getToday()))
        text_main_value.setText(yourValue + getString(R.string.main_aftervalue))
        text_main_perkg.setText(getString(R.string.main_beforesquid) + getFormattedWon(pricePerKg))

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
