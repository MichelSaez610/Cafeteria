package com.cafe.cafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.cafe.cafeteria.databinding.ActivityRegistreBinding
import com.google.android.material.snackbar.Snackbar

class RegistreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityRegistreBinding = DataBindingUtil.setContentView(this, R.layout.activity_registre)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.botonRegistrarse.setOnClickListener{
            val registreUsuari = binding.registreText.text.toString()
            val registrePassword = binding.registrePass.text.toString()
            if (registreUsuari == "" || registrePassword == "") {
                Snackbar.make(binding.root, "L'usuari o contrasenya no poden estar en blanc", Snackbar.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("usuariRegistrat", registreUsuari)
                intent.putExtra("passwordRegistrada", registrePassword)
                startActivity(intent)
            }
        }
    }
}