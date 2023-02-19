package com.example.crunchyrollfixed

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import com.example.crunchyrollfixed.databinding.ActivityRegistrarBinding

class registrar : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val spannable = SpannableString("¿Ya tienes una cuenta? Acceder")

        binding.logo2.setImageResource(R.drawable.crunchyroll)
        binding.cruz2.setImageResource(R.drawable.cruz_balca)

        binding.cruz2.setOnClickListener{
            val intent = Intent(this@registrar, MainActivity::class.java)
            startActivity(intent)
        }

        binding.yatienes.setOnClickListener{
            val intent = Intent(this@registrar, login::class.java)
            startActivity(intent)
        }

        spannable.setSpan(android.text.style.ForegroundColorSpan(Color.parseColor("#f47521")),
            23,
            30,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.yatienes.text = spannable
    }
}