package com.sanggggg.yourvalue.view.intro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import com.sanggggg.yourvalue.R
import com.sanggggg.yourvalue.view.main.MainActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_weight.*
import timber.log.Timber
import javax.inject.Inject

class WeightFragment : DaggerFragment() {

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_weight.setOnClickListener {
            preferences.edit().putInt("user_weight", edittext_weight.text.toString().toInt()).commit()
            activity?.let {
                val intent = MainActivity.createIntent(it)
                it.startActivity(intent)
                it.finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_weight, container, false)
    }
}