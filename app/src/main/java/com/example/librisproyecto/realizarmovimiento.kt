package com.example.librisproyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class activity_realizarmovimiento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizarmovimiento)

        val btnSalir = findViewById<ImageView?>(R.id.btnSalirMovimiento)
        val etNombre = findViewById<EditText>(R.id.etNombreLibro)
        val etAutor = findViewById<EditText>(R.id.etAutorLibro)
        val etEditorial = findViewById<EditText>(R.id.etEditorialLibro)
        val btnPrestar = findViewById<Button>(R.id.btnPedirPrestado)
        val btnDevolver = findViewById<Button>(R.id.btnDevolverLibro)

        btnSalir?.setOnClickListener {
            finish()
        }

        btnPrestar.setOnClickListener {
            procesarMovimiento("Préstamo", etNombre, etAutor, etEditorial)
        }

        btnDevolver.setOnClickListener {
            procesarMovimiento("Devolución", etNombre, etAutor, etEditorial)
        }
    }

    private fun procesarMovimiento(
        tipo: String,
        etNombre: EditText,
        etAutor: EditText,
        etEditorial: EditText
    ) {
        val nombre = etNombre.text.toString().trim()
        val autor = etAutor.text.toString().trim()
        val editorial = etEditorial.text.toString().trim()

        if (nombre.isEmpty() || autor.isEmpty() || editorial.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los datos del libro", Toast.LENGTH_SHORT).show()
            return
        }

        // Aquí después conectaremos la petición HTTP hacia PHP/MySQL
        Toast.makeText(this, "$tipo registrado: $nombre ($editorial)", Toast.LENGTH_LONG).show()

        // Limpiar los campos tras registrar
        etNombre.text.clear()
        etAutor.text.clear()
        etEditorial.text.clear()
    }
}