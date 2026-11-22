package com.example.librisproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ajustes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        val btnSalir = findViewById<ImageView?>(R.id.btnSalirAjustes)
        val btnHistorial = findViewById<Button>(R.id.btnVerHistorial)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        btnSalir?.setOnClickListener {
            finish()
        }

        btnHistorial.setOnClickListener {
            val intent = Intent(this, historial::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            // Limpia la pila de pantallas y regresa al Login (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}