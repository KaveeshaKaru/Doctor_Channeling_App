package com.example.myhealth




import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import android.text.InputFilter
import android.widget.Toast
import java.util.Calendar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val appDateEditText = findViewById<EditText>(R.id.appDate)
        val phoneNoEditText = findViewById<EditText>(R.id.phoneNo)

        appDateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                appDateEditText.setText(selectedDate)
            }, year, month, day)

            datePickerDialog.show()
        }

        // Set a TextWatcher for the phoneNo EditText
        phoneNoEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val phoneNumber = s.toString()

                if (phoneNumber.length == 10) {

                    phoneNoEditText.error = null // Clear any previous error message
                } else {
                    phoneNoEditText.error = "Phone number must be 10 digits"
                }
            }
        })

        // Set an InputFilter to limit the number of digits to 10
        val maxLength = 10
        val inputFilter = InputFilter { source, start, end, dest, dstart, dend ->
            val newLength = dest.length - (dend - dstart) + source.length
            if (newLength > maxLength) {
                "" // If the maximum number of digits is reached, return an empty string to prevent further input.
            } else null
        }

        phoneNoEditText.filters = arrayOf(inputFilter)
    }
}
//import android.app.DatePickerDialog
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.EditText
//import android.text.Editable
//import android.text.TextWatcher
//import android.text.InputFilter
//import android.widget.Button
//import android.widget.Toast
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import java.util.Calendar
//
//class DetailActivity : AppCompatActivity() {
//
//    private lateinit var appointmentDao: AppointmentDao
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
//
//        val appDateEditText = findViewById<EditText>(R.id.appDate)
//        val phoneNoEditText = findViewById<EditText>(R.id.phoneNo)
//
//        appDateEditText.setOnClickListener {
//            val calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
//                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
//                appDateEditText.setText(selectedDate)
//            }, year, month, day)
//
//            datePickerDialog.show()
//        }
//
//        // Set a TextWatcher for the phoneNo EditText
//        phoneNoEditText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                val phoneNumber = s.toString()
//
//                if (phoneNumber.length == 10) {
//
//                    phoneNoEditText.error = null // Clear any previous error message
//                } else {
//                    phoneNoEditText.error = "Phone number must be 10 digits"
//                }
//            }
//        })
//
//        // Set an InputFilter to limit the number of digits to 10
//        val maxLength = 10
//        val inputFilter = InputFilter { source, start, end, dest, dstart, dend ->
//            val newLength = dest.length - (dend - dstart) + source.length
//            if (newLength > maxLength) {
//                "" // If the maximum number of digits is reached, return an empty string to prevent further input.
//            } else null
//        }
//
//        phoneNoEditText.filters = arrayOf(inputFilter)
//
//        val db = AppDatabase.getDatabase(this)
//        appointmentDao = db.appointmentDao()
//
//        val pname = findViewById<EditText>(R.id.pname)
//        val phoneNo = findViewById<EditText>(R.id.phoneNo)
//        val appDate = findViewById<EditText>(R.id.appDate)
//        val bookBtn = findViewById<Button>(R.id.bookBtn)
//
//        bookBtn.setOnClickListener {
//            val name = pname.text.toString()
//            val phone = phoneNo.text.toString()
//            val date = appDate.text.toString()
//
//            val appointment = Appointment(name = name, phoneNo = phone, appointmentDate = date)
//
//            GlobalScope.launch(Dispatchers.IO) {
//                appointmentDao.insert(appointment)
//            }
//        }
//
//
//    }
//}

