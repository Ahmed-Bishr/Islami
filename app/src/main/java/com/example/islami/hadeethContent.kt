package com.example.islami

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.databinding.ActivityHadeethContentBinding

class hadeethContent : AppCompatActivity() {

    lateinit var binding: ActivityHadeethContentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadeethContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("hadeeth_name")
        val postion = number()
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.titleTextView.text = "$title $postion"
    }

    private fun number(): Int {
        var indext = 0
        for (i in 1..50) {
            indext = i
        }
        return indext
    }


}