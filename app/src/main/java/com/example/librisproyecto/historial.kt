package com.example.librisproyecto

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class historial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        val btnSalir = findViewById<ImageView?>(R.id.btnSalirHistorial)

        btnSalir?.setOnClickListener {
            finish()
        }
    }
}