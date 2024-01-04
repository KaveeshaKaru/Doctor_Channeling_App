package com.example.myhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myhealth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username : EditText
    lateinit var Password: EditText
    lateinit var LoginBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginBtn.setOnClickListener(View.OnClickListener {
            if (binding.username.text.toString() == "user" && binding.Password.text.toString() == "1234"){
                Toast.makeText(this,"Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            }else {
                Toast.makeText(this,"Login Failed !!", Toast.LENGTH_SHORT).show()
            }
        })

        val btnNavigate: Button = findViewById(R.id.RegisterBtn)
        btnNavigate.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            val btnNavigate: Button = findViewById(R.id.RegisterBtn)
            btnNavigate.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

            }
        }
    }
}