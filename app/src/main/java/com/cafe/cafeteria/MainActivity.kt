package com.cafe.cafeteria

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.cafe.cafeteria.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usuario = intent.getStringExtra("usuariRegistrat")
        val password = intent.getStringExtra("passwordRegistrada")

        binding.botonGoRegistre.setOnClickListener{
            val intent = Intent(this, RegistreActivity::class.java)
            startActivity(intent)
        }

        binding.botonLogin.setOnClickListener{
            val inputUsuario = binding.loginText.text.toString()
            val inputPassword = binding.loginPass.text.toString()

            if (inputUsuario == usuario || inputPassword == password) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(binding.root, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT).show()
            }

        }

    }
}