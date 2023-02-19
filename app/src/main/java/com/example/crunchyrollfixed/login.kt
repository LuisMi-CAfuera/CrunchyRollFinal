package com.example.crunchyrollfixed

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.crunchyrollfixed.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val spannable = SpannableString("Al usar tu cuenta accedes a nuestros Términos y Políticas de Privacidad y confirmas que tienes 16 años o más.")

        binding.logo1.setImageResource(R.drawable.crunchyroll)
        binding.cruz1.setImageResource(R.drawable.cruz_balca)
        binding.acceder.setOnClickListener{
            val intent = Intent(this@login, Principal::class.java)
            startActivity(intent)
        }

        binding.cruz1.setOnClickListener{
            val intent = Intent(this@login, MainActivity::class.java)
            startActivity(intent)
        }

        binding.crear2.setOnClickListener{
            val intent = Intent(this@login, registrar::class.java)
            startActivity(intent)
        }

        spannable.setSpan(ForegroundColorSpan(Color.parseColor("#f47521")),
            37,
            45,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        spannable.setSpan(ForegroundColorSpan(Color.parseColor("#f47521")),
            48,
            71,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.terminosYCondiciones.text = spannable

    }
}