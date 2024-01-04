package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myhealth.databinding.ActivityMain3Binding
import com.example.myhealth.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMain3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFragment1.setOnClickListener{
            goToFragment(Fragment1())
        }
        binding.buttonFragment2.setOnClickListener{
            goToFragment(Fragment2())
        }

    }
    private fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
    }



}