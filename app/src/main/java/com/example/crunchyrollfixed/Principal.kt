package com.example.crunchyrollfixed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crunchyrollfixed.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    //fragmentos en kotlin
    var fragmento1 = primer_fragment_inicio()
    var fragmento2 = segundo_fragment_listas()
    var fragmento3 = tercer_fragment_explorar()
    var fragmento4 = cuarto_fragment_simulcast()
    var fragmento5 = quinto_fragment_cuenta()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigation1.setOnItemSelectedListener {
            when(it.itemId){
                R.id.primer_fragment_inicio -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragmento1).commit()
                    true
                }
                R.id.segundo_fragment_litas -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragmento2).commit()
                    true
                }
                R.id.tercer_fragment_explorar -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragmento3).commit()
                    true
                }
                R.id.cuarto_fragment_simulcast-> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragmento4).commit()
                    true
                }
                R.id.quinto_fragment_cuenta -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragmento5).commit()
                    true
                }
                else -> false
            }
        }


    }
}