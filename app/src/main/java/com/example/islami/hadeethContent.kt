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
    lateinit var adaptor: fileViewAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadeethContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("hadeethname")
        val index = intent.getIntExtra("hadeethposition", -1)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.titleTextView.text = "$title $index"
        adaptor = fileViewAdaptor(null)
        binding.hadeethView.adapter = adaptor
        readFromFile(index)
    }

    fun readFromFile(index: Int) {
        var filename = "h${index}.txt"
        val fileReader = application.assets.open(filename).bufferedReader().use {
            it.readText()
        }
        val dataSpliter = fileReader.split("\n")
        adaptor.adaptorUpdate(dataSpliter)
    }

}