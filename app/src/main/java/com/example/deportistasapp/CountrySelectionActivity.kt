package com.example.deportistasapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class CountrySelectionActivity : AppCompatActivity() {
    private val deportistasMap = mapOf(
        "Argentina" to listOf(
            Deportista("Lionel Messi", "Fútbol", true),
            Deportista("Manu Ginóbili", "Baloncesto", false),
            Deportista("Juan Martín del Potro", "Tenis", false),
            Deportista("Luciana Aymar", "Hockey sobre césped", false),
            Deportista("Paula Pareto", "Judo", false),
            Deportista("Sergio Agüero", "Fútbol", false),
            Deportista("Gabriela Sabatini", "Tenis", false),
            Deportista("Carlos Delfino", "Baloncesto", true),
            Deportista("Diego Maradona", "Fútbol", false),
            Deportista("David Nalbandian", "Tenis", false)
        ),
        "Brasil" to listOf(
            Deportista("Pelé", "Fútbol", false),
            Deportista("Neymar Jr.", "Fútbol", true),
            Deportista("Gustavo Kuerten", "Tenis", false),
            Deportista("Marta Vieira da Silva", "Fútbol", true),
            Deportista("Ayrton Senna", "Automovilismo", false),
            Deportista("Oscar Schmidt", "Baloncesto", false),
            Deportista("Gabriel Medina", "Surf", true),
            Deportista("Thiago Silva", "Fútbol", true),
            Deportista("Zico", "Fútbol", false),
            Deportista("Hulk", "Fútbol", true)
        ),
        "Colombia" to listOf(
            Deportista("James Rodríguez", "Fútbol", true),
            Deportista("Caterine Ibargüen", "Atletismo", false),
            Deportista("Nairo Quintana", "Ciclismo", true),
            Deportista("Radamel Falcao", "Fútbol", true),
            Deportista("Mariana Pajón", "BMX", true),
            Deportista("Juan Pablo Montoya", "Automovilismo", false),
            Deportista("Fernando Gaviria", "Ciclismo", true),
            Deportista("Carlos Valderrama", "Fútbol", false),
            Deportista("Rigoberto Urán", "Ciclismo", true),
            Deportista("Yuberjen Martínez", "Boxeo", true)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_selection)

        val countries = intent.getStringArrayListExtra("countries") ?: return
        val spinner = findViewById<Spinner>(R.id.country_spinner)
        val listView = findViewById<ListView>(R.id.deportistas_list)

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCountry = countries[position]
                val deportistas = deportistasMap[selectedCountry] ?: emptyList()

                val adapter = ArrayAdapter(this@CountrySelectionActivity, android.R.layout.simple_list_item_1, deportistas.map { it.name })
                listView.adapter = adapter

                listView.setOnItemClickListener { _, _, index, _ ->
                    val deportista = deportistas[index]
                    val intent = Intent(this@CountrySelectionActivity, DeportistaDetailActivity::class.java)
                    intent.putExtra("deportista", deportista)
                    startActivity(intent)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}

data class Deportista(val name: String, val deporte: String, val enActividad: Boolean) : java.io.Serializable
