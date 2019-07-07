package com.sanggggg.yourvalue.view.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.sanggggg.yourvalue.R
import dagger.android.AndroidInjector
import dagger.android.DaggerActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_intro.*
import javax.inject.Inject

class IntroActivity : DaggerAppCompatActivity() {

    companion object {
        fun createIntent(context: Context) : Intent = Intent(context, IntroActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val adapter = IntroPagerAdapter(supportFragmentManager, this)

        intro_pager.adapter = adapter
        intro_dots.setViewPager(intro_pager)
    }
}