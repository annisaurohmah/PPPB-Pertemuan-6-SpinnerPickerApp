package com.example.spinnerpickerapp6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerpickerapp6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf(
            "Indonesia",
            "United States",
            "United Kingdom",
            "Germany",
            "France",
            "Australia",
            "Japan",
            "China",
            "Brazil",
            "Canada"
        )

        val cities = resources.getStringArray(R.array.cities)


        with(binding) {
            val countriesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countries
            )

            countriesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinCountries.adapter = countriesAdapter

            val citiesAdapter = ArrayAdapter(
                this@MainActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countries
            )

            citiesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinCountries.adapter = countriesAdapter

            var selectedDate = ""
            datePick.init(
                datePick.year,
                datePick.month,
                datePick.dayOfMonth
            ) { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year "
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            var selectedTime = ""
            timePicker.setOnTimeChangedListener { _, hourOfDay, minutes ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }
        }
    }
}