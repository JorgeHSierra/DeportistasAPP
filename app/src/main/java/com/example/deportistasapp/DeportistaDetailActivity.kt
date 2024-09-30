package com.example.deportistasapp
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeportistaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deportista_detail)

        val deportista = intent.getSerializableExtra("deportista") as? Deportista

        val nameTextView = findViewById<TextView>(R.id.deportista_name)
        val deporteTextView = findViewById<TextView>(R.id.deportista_deporte)
        val actividadTextView = findViewById<TextView>(R.id.deportista_actividad)

        deportista?.let {
            nameTextView.text = it.name
            deporteTextView.text = "Deporte: ${it.deporte}"
            actividadTextView.text = if (it.enActividad) "En actividad" else "Retirado"
        }
    }
}
