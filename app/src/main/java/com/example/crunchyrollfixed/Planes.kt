package com.example.crunchyrollfixed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crunchyrollfixed.databinding.ActivityPlanesBinding

class Planes : AppCompatActivity() {
    private lateinit var binding: ActivityPlanesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlanesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planes)
    }
}