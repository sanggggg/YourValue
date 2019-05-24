package com.sanggggg.yourvalue.view.intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.sanggggg.yourvalue.R

class IntroPagerAdapter(val res: List<String>, val context: Context) : PagerAdapter() {
    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.page_intro, container, false)

        view.findViewById<TextView>(R.id.text_intro).setText(res.get(position))

        return view
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 === p1
    }

    override fun getCount(): Int {
        return res.size;
    }

}