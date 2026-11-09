package com.example.librisproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias de los elementos del Login
        val etNombre = findViewById<EditText?>(R.id.etNombre)
        val etContrasena = findViewById<EditText?>(R.id.etContrasena)
        val btnIngresar = findViewById<Button?>(R.id.btnIngresar)
        val tvIrRegistro = findViewById<TextView?>(R.id.tvIrRegistro)

        // Botón de Ingresar (Salto al Menú Principal)
        btnIngresar?.setOnClickListener {
            val usuario = etNombre?.text?.toString() ?: ""
            val pass = etContrasena?.text?.toString() ?: ""

            if (usuario.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, menu::class.java)
                startActivity(intent)
            }
        }

        // Enlace para ir a la pantalla de Registro de Nueva Cuenta
        tvIrRegistro?.setOnClickListener {
            val intent = Intent(this, registrodenuevacuenta::class.java)
            startActivity(intent)
        }
    }
}