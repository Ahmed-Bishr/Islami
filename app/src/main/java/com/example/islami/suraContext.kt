package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivitySuraContextBinding

class suraContext : AppCompatActivity() {
    lateinit var binding: ActivitySuraContextBinding
    lateinit var adaptor: fileViewAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraContextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(Constants.suraName)
        val index = intent.getIntExtra(Constants.suraPosition, -1)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.titleTextView.text = title
        adaptor = fileViewAdaptor(null)
        binding.suraView.adapter = adaptor
        readFromFile(index)
    }

    fun readFromFile(index: Int) {
        var fileName = "${index}.txt"
        val readDataFromFileSura = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val dataSpliter = readDataFromFileSura.split("\n")
        adaptor.adaptorUpdate(dataSpliter)

    }
}