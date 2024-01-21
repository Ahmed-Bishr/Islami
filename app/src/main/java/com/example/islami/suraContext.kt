package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivitySuraContextBinding

class suraContext : AppCompatActivity() {
    lateinit var binding: ActivitySuraContextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraContextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(Constants.suraName)
        val postion = intent.getStringExtra(Constants.suraPosition)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.titleTextView.text = title


    }
}