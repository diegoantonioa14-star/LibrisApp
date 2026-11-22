package com.example.librisproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSalir = findViewById<ImageView?>(R.id.btnSalir)
        val btnTransacciones = findViewById<Button?>(R.id.btnTransacciones)
        val btnRealizarMovimiento = findViewById<Button?>(R.id.btnRealizarMovimiento)
        val btnCatalogo = findViewById<Button?>(R.id.btnCatalogo)
        val btnAjustes = findViewById<Button?>(R.id.btnAjustes)

        btnSalir?.setOnClickListener {
            finish() // Regresa al Login
        }

        btnTransacciones?.setOnClickListener {
            val intent = Intent(this, transacciones::class.java)
            startActivity(intent)
        }

        btnRealizarMovimiento?.setOnClickListener {
            val intent = Intent(this, activity_realizarmovimiento::class.java)
            startActivity(intent)
        }

        btnCatalogo?.setOnClickListener {
            val intent = Intent(this, activity_catalogolibros::class.java)
            startActivity(intent)
        }

        btnAjustes?.setOnClickListener {
            val intent = Intent(this, ajustes::class.java)
            startActivity(intent)
        }
    }

}