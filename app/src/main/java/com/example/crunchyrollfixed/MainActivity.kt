package com.example.crunchyrollfixed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crunchyrollfixed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.crunchyroll)
        binding.Acceder.setOnClickListener {
            val intent = Intent(this@MainActivity, Principal::class.java)
            startActivity(intent)
        }

        binding.crear.setOnClickListener{
            val intent = Intent(this@MainActivity, registrar::class.java)
            startActivity(intent)
        }

        binding.Explorar.setOnClickListener{
            val intent = Intent(this@MainActivity, Planes::class.java)
            startActivity(intent)
        }

    }
}