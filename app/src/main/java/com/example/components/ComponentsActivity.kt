package com.example.components

import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.ListView
import android.widget.NumberPicker
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.SearchView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class ComponentsActivity : AppCompatActivity() {

    private lateinit var activityContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)
        activityContext = this

        val calendar: CalendarView = findViewById(R.id.calendar)
        val dateText: TextView = findViewById(R.id.dateText)
        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            dateText.text = "Fecha seleccionada: $date"
        }

        val calendar_instance = Calendar.getInstance()
        calendar_instance.set(2026,5 - 1,8)
        calendar.date = calendar_instance.timeInMillis

        // Para poner el lunes como primer día de la semana
        val day = calendar.firstDayOfWeek
        calendar.firstDayOfWeek = (day + 1) % 7

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        progressBar.progress = 0

        val seekbar: SeekBar = findViewById(R.id.seekbar)

        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    Toast.makeText(activityContext, "Tu lo cambiaste", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }

            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })


        val raitingBar: RatingBar = findViewById(R.id.ratingBar)

        GlobalScope.launch {
            progressManager(progressBar)
            progressManager(seekbar)
        }


        val number_picker: NumberPicker = findViewById(R.id.numberPicker)
        number_picker.minValue = 1
        number_picker.maxValue = 60
        number_picker.value = 10
//        Hace que funcione como una rueda (cuando termina se repite)
        number_picker.wrapSelectorWheel = true
        number_picker.setFormatter { i -> String.format("%02d", i)}
    }

    private fun progressManager(progressBar: ProgressBar) {
        while (progressBar.progress < progressBar.max) {
            sleep(100L)
            progressBar.incrementProgressBy(5)
        }
    }
}