package com.bimabagaskhoro.apptest.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bimabagaskhoro.apptest.databinding.ActivityCreatePasswordBinding


class CreatePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            imgBack.setOnClickListener {
                val intent = Intent(this@CreatePasswordActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            btnMakePassword.setOnClickListener {
                onSucceed()
            }
            btnCancel.setOnClickListener {
                val intent = Intent(this@CreatePasswordActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun onSucceed() {
        binding.apply {
            val password = edtPassword.text.toString()
            val confPassword = edtConfirmPassword.text.toString()
            if (password.isNullOrEmpty()) {
                edtPassword.error = "Field the password"
                edtPassword.requestFocus()
            } else if (password.length < 8) {
                edtPassword.error = "Password is too week"
                edtPassword.requestFocus()
            } else if (confPassword.isNullOrEmpty()) {
                edtConfirmPassword.error = "Field the confirm password"
                edtConfirmPassword.requestFocus()
            } else if (password != confPassword) {
                edtConfirmPassword.error = "Password must much"
                edtConfirmPassword.requestFocus()
            } else {
                showDialogs()
            }

        }
    }

    private fun showDialogs() {
        val bottomSheet = BottomSheetFragment()
        bottomSheet.show(supportFragmentManager,"TAG")
    }

}
