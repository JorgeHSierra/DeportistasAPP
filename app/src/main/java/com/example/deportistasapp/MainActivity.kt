package com.example.deportistasapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val country1 = findViewById<EditText>(R.id.country1)
        val country2 = findViewById<EditText>(R.id.country2)
        val country3 = findViewById<EditText>(R.id.country3)
        val buttonConfirm = findViewById<Button>(R.id.button_confirm_countries)

        buttonConfirm.setOnClickListener {
            val countries = listOf(country1.text.toString(), country2.text.toString(), country3.text.toString())
            if (countries.all { it.isNotEmpty() }) {
                val intent = Intent(this, CountrySelectionActivity::class.java)
                intent.putStringArrayListExtra("countries", ArrayList(countries))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Debe ingresar exactamente 3 países", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
