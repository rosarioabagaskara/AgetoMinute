package com.example.agebyminute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectDateButton = findViewById<Button>(R.id.button)
        selectDateButton.setOnClickListener {
            datePicker()
        }
    }

    fun datePicker(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val days = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, days -> calendarText(year, month, days) }, year,month,days)
        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()
    }

    fun calendarText(year:Int, month:Int, days:Int){
        val textViewCalendar: TextView = findViewById(R.id.textView8)
        val textViewMinutes: TextView = findViewById(R.id.textView10)
        textViewCalendar.setText("$days.${month+1}.$year")
        textViewCalendar.visibility = View.VISIBLE

        val sdf = SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH)
        val selectedDate = sdf.parse("$days/${month+1}/$year")
        selectedDate?.let{
            val selectedDateInMinutes = selectedDate.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            currentDate.let {
                val currentDateInMinutes = currentDate.time/60000
                val ageInMinutes = currentDateInMinutes - selectedDateInMinutes
                textViewMinutes.setText(ageInMinutes.toString())
                textViewMinutes.visibility = View.VISIBLE
            }

        }

    }

































//    fun datePicker(){
//        val myCalendar = Calendar.getInstance()
//        val calendarYear = myCalendar.get(Calendar.YEAR)
//        val calendarMonth = myCalendar.get(Calendar.MONTH)
//        val calendarDay = myCalendar.get(Calendar.DAY_OF_MONTH)
//
//        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, calendarYear, calendarMonth, calendarDay -> dateText(calendarYear,calendarMonth,calendarDay) },
//            calendarYear,calendarMonth,calendarDay)
//        dpd.datePicker.maxDate = System.currentTimeMillis()
//        dpd.show()
//
//    }
//
//    fun dateText(calendarYear:Int, calendarMonth:Int, calendarDay:Int){
//
//        dateTextView = findViewById(R.id.textView8)
//        minutesTextView = findViewById(R.id.textView10)
//        dateTextView?.text = "$calendarDay.${calendarMonth+1}.$calendarYear"
//        dateTextView?.visibility = View.VISIBLE
//
//        val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
//        var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
//        val currentDateInMinutes = currentDate.time/60000
//        val selectedDate = sdf.parse("$calendarDay/${calendarMonth+1}/$calendarYear")
//        val selectedDateInMinutes = selectedDate.time/60000
//        var differenceDate = currentDateInMinutes - selectedDateInMinutes
//        minutesTextView?.visibility = View.VISIBLE
//        minutesTextView?.text = differenceDate.toString()
//
//    }
}