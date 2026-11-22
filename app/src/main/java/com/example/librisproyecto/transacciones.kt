package com.example.librisproyecto

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class transacciones : AppCompatActivity() {

    private lateinit var ivFotoLibro: ImageView
    private var fotoBitmap: Bitmap? = null
    private lateinit var tomarFotoLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transacciones)

        val btnSalir = findViewById<ImageView?>(R.id.btnSalirTransacciones)
        val etNombre = findViewById<EditText>(R.id.etDonarNombre)
        val etAutor = findViewById<EditText>(R.id.etDonarAutor)
        val etEditorial = findViewById<EditText>(R.id.etDonarEditorial)
        val btnDonar = findViewById<Button>(R.id.btnConfirmarDonacion)
        val btnTomarFoto = findViewById<Button>(R.id.btnTomarFoto)
        ivFotoLibro = findViewById(R.id.ivFotoLibro)

        // Inicializar el lanzador para capturar la foto de la cámara
        tomarFotoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                fotoBitmap = data?.extras?.get("data") as? Bitmap
                if (fotoBitmap != null) {
                    ivFotoLibro.setImageBitmap(fotoBitmap)
                }
            }
        }

        btnSalir?.setOnClickListener {
            finish()
        }

        btnTomarFoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            tomarFotoLauncher.launch(intent)
        }

        btnDonar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val autor = etAutor.text.toString().trim()
            val editorial = etEditorial.text.toString().trim()

            if (nombre.isEmpty() || autor.isEmpty() || editorial.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los datos del libro", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (fotoBitmap == null) {
                Toast.makeText(this, "Por favor toma una foto del estado del libro", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Aquí después mandaremos la información y el bitmap/imagen hacia tu PHP/MySQL
            Toast.makeText(this, "¡Donación registrada con éxito: $nombre!", Toast.LENGTH_LONG).show()

            // Limpiar campos y restablecer imagen
            etNombre.text.clear()
            etAutor.text.clear()
            etEditorial.text.clear()
            ivFotoLibro.setImageResource(android.R.drawable.ic_menu_camera)
            fotoBitmap = null
        }
    }
}