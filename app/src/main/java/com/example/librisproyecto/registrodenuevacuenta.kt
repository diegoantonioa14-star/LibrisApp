package com.example.librisproyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class registrodenuevacuenta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrodenuevacuenta)

        val etNombre = findViewById<EditText>(R.id.etNombreReg)
        val etApellido = findViewById<EditText>(R.id.etApellidoReg)
        val etMatricula = findViewById<EditText>(R.id.etMatriculaReg)
        val etCorreo = findViewById<EditText>(R.id.etCorreoReg)
        val etContrasena = findViewById<EditText>(R.id.etContrasenaReg)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistrarse)

        btnRegistrarse?.setOnClickListener {
            val nombre = etNombre?.text?.toString() ?: ""
            val apellido = etApellido?.text?.toString() ?: ""
            val matricula = etMatricula?.text?.toString() ?: ""
            val correo = etCorreo?.text?.toString() ?: ""
            val pass = etContrasena?.text?.toString() ?: ""

            if (nombre.isEmpty() || apellido.isEmpty() || matricula.isEmpty() || correo.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                finish() // Regresa a la pantalla de Login
            }
        }
    }
}