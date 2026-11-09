package com.example.librisproyecto

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
            Toast.makeText(this, "Transacciones", Toast.LENGTH_SHORT).show()
        }

        btnRealizarMovimiento?.setOnClickListener {
            Toast.makeText(this, "Realizar movimiento", Toast.LENGTH_SHORT).show()
        }

        btnCatalogo?.setOnClickListener {
            Toast.makeText(this, "Catálogo de libros", Toast.LENGTH_SHORT).show()
        }

        btnAjustes?.setOnClickListener {
            Toast.makeText(this, "Ajustes de cuenta", Toast.LENGTH_SHORT).show()
        }
    }
}