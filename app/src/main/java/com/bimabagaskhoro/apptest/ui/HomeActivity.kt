package com.bimabagaskhoro.apptest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bimabagaskhoro.apptest.databinding.ActivityHomeBinding
import com.bimabagaskhoro.apptest.ui.minigame.MiniGameFragment
import com.bimabagaskhoro.apptest.ui.onBoarading.MainActivity
import com.bimabagaskhoro.apptest.ui.password.CreatePasswordActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            cardViewMakePassword.setOnClickListener {
                val intent = Intent(this@HomeActivity, CreatePasswordActivity::class.java)
                startActivity(intent)
            }
            imgBack.setOnClickListener {
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intent)
            }
            cardGame1.setOnClickListener {
                getDialogs()
            }
        }
    }

    private fun getDialogs() {
        val miniGame = MiniGameFragment()
        miniGame.show(supportFragmentManager,"TAG")
    }
}