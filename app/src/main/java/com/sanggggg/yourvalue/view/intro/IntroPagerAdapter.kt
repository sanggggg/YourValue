package com.sanggggg.yourvalue.view.intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.sanggggg.yourvalue.R

class IntroPagerAdapter(fm : FragmentManager, context: Context) : FragmentPagerAdapter(fm) {

    private val pages = listOf(
        IntroFragment(context.getString(R.string.page1)),
        IntroFragment(context.getString(R.string.page2)),
        WeightFragment()
    )

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size
}