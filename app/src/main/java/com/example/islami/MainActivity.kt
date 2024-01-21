package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.Fragments.QuranFragment
import com.example.islami.Fragments.SebhaFragment
import com.example.islami.Fragments.hadeethFragment
import com.example.islami.Fragments.radioFragment
import com.example.islami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    pushFragment(hadeethFragment())
                }

                R.id.navigation_tasbeeh -> {
                    pushFragment(SebhaFragment())
                }

                R.id.navigation_radio -> {
                    pushFragment(radioFragment())
                }
            }

            return@setOnItemSelectedListener true
        }
        binding.navigationBar.selectedItemId = R.id.navigation_quran

    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.frameMainScreen.id, fragment)
            .commit()
    }

}