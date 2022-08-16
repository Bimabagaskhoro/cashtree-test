package com.bimabagaskhoro.apptest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bimabagaskhoro.apptest.R
import com.bimabagaskhoro.apptest.model.OnBoardData

class OnBoardingAdapter (private var context: Context, private var onBoardData: List<OnBoardData>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }

    override fun getCount(): Int {
        return onBoardData.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.onboard_screen, null)

        val imageView: ImageView = view.findViewById(R.id.img_onboard)
        val tittle: TextView = view.findViewById(R.id.tv_tittle_onboard)
        val tittle2: TextView = view.findViewById(R.id.tv_tittle_2_onboard)
        val desc : TextView = view.findViewById(R.id.tv_desc_onboard)

        imageView.setImageResource(onBoardData[position].imgOnboard)
        tittle.text = onBoardData[position].tittle
        tittle2.text = onBoardData[position].tittle2
        desc.text = onBoardData[position].desc

        container.addView(view)
        return view

    }
}