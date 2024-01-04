package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val btnNavigate: Button = findViewById(R.id.abtBtn)
        btnNavigate.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
            val btnNavigate: Button = findViewById(R.id.abtBtn)
            btnNavigate.setOnClickListener {
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)

            }
        }


    }
}