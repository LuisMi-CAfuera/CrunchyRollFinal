package com.example.crunchyrollfixed

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import com.example.crunchyrollfixed.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

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

        //Funcion para logearse en firebase
        logearse()

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
    private fun logearse() {
        title = "Login"
        binding.acceder.setOnClickListener {
            if (binding.usuario.text.isNotEmpty() && binding.passwords.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
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
        builder.setMessage("Se ha producido un error autenticando al usuario, o no tiene una cuenta")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email:String,provider: ProviderType){
        val intent: Intent = Intent(this, primer_fragment_inicio::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(intent)
    }
}