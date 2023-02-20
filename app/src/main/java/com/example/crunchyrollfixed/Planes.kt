package com.example.crunchyrollfixed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.crunchyrollfixed.databinding.ActivityPlanesBinding

class Planes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planes)

        //cuando se le de click a la cruz se regresa a la pantalla principal sin binding
        val cruz = findViewById<ImageView>(R.id.cruz3)
        cruz.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}