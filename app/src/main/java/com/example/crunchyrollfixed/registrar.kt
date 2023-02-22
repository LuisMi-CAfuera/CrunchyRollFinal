package com.example.crunchyrollfixed

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import androidx.appcompat.app.AlertDialog
import com.example.crunchyrollfixed.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth

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
    private fun setup() {
        title = "Login"

        binding.acceder.setOnClickListener {
            if (binding.usuario.text.isNotEmpty() && binding.passwords.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        binding.usuario.text.toString(),
                        binding.passwords.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                    }
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email:String,provider: ProviderType){
        val homeIntent: Intent = Intent(this, primer_fragment_inicio::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}