package com.training.practice1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.training.practice1.R
import com.training.practice1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragment: MealFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews()
    {
        fragment=MealFragment()
        supportFragmentManager.beginTransaction().add(R.id.container1,fragment).commit()
    }
}