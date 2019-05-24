package com.sanggggg.yourvalue.view.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanggggg.yourvalue.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    private var resource: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        resource.add("page 1")
        resource.add("page 2")
        resource.add("page 3")
    }
}