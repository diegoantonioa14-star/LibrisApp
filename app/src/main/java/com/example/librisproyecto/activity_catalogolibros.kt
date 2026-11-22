package com.example.librisproyecto

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class activity_catalogolibros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogolibros)

        // Botón para regresar al menú principal
        val btnSalir = findViewById<ImageView?>(R.id.btnSalirCatalogo)
        btnSalir?.setOnClickListener {
            finish()
        }
    }
}