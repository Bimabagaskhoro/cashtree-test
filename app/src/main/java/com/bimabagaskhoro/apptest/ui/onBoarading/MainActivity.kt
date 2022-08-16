package com.bimabagaskhoro.apptest.ui.onBoarading

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.bimabagaskhoro.apptest.R
import com.bimabagaskhoro.apptest.model.OnBoardData
import com.bimabagaskhoro.apptest.ui.HomeActivity
import com.bimabagaskhoro.apptest.ui.adapter.OnBoardingAdapter
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {

    var onBoardingAdapter: OnBoardingAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager : ViewPager? = null
    var home: TextView? = null
    var position = 0
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (restorePrefDate()){
            val i = Intent(applicationContext, HomeActivity::class.java)
            startActivity(i)
        }
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_indicator)
        home = findViewById(R.id.btn_sf)

        val onBoardingData:MutableList<OnBoardData> = ArrayList()
        onBoardingData.add(OnBoardData(
            getString(R.string.lorem_1_onboard),
            getString(R.string.lorem_onboard),
            getString(R.string.lorem_desc_onboard),
            R.drawable.img_onboard)
        )
        onBoardingData.add(OnBoardData(
            getString(R.string.lorem_2_onboard),
            getString(R.string.lorem_onboard),
            getString(R.string.lorem_desc_onboard),
            R.drawable.img_onboard)
        )
        onBoardingData.add(OnBoardData(
            getString(R.string.lorem_3_onboard),
            getString(R.string.lorem_onboard),
            getString(R.string.lorem_desc_onboard),
            R.drawable.img_onboard)
        )
        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem
        home?.setOnClickListener {
            if (position < onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingData.size){
                savePrefData()
                val i = Intent(applicationContext, HomeActivity::class.java)
                startActivity(i)
            }
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            @SuppressLint("SetTextI18n")
            override fun onTabReselected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size -1){
                    home!!.text = "Home"
                } else {
                    home!!.text = "Next"
                }
            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardData: List<OnBoardData>){
        onBoardingViewPager = findViewById(R.id.viewPager)
        onBoardingAdapter = OnBoardingAdapter(this, onBoardData)
        onBoardingViewPager!!.adapter = onBoardingAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    @SuppressLint("CommitPrefEdits")
    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefDate(): Boolean {
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }
}