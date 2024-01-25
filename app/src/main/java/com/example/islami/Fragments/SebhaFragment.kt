package com.example.islami.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivitySebhaFragmentBinding

class SebhaFragment : Fragment() {

    lateinit var binding: ActivitySebhaFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySebhaFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countTasbeeh()
    }

    private fun countTasbeeh() {
        var count = 0
        var rotation = 9.166667F
        binding.tasbeeh.setOnClickListener {
            count++
            rotation++
            binding.body.rotation = rotation
            binding.tasbeehCount.text = count.toString()

            if (count == 33 && binding.tasbeeh.text == "سبحان الله") {
                count = 0
                binding.tasbeehCount.text = count.toString()
                binding.tasbeeh.text = "الله اكبر"

            } else if (count == 33 && binding.tasbeeh.text == "الله اكبر") {
                count = 0
                binding.tasbeehCount.text = count.toString()
                binding.tasbeeh.text = "استغفر الله"

            } else if (count == 33 && binding.tasbeeh.text == "استغفر الله") {
                count = 0
                binding.tasbeehCount.text = count.toString()
                binding.tasbeeh.text = "الحمد لله"
            } else if (count == 33 && binding.tasbeeh.text == "الحمد لله") {
                count = 0
                binding.tasbeehCount.text = count.toString()
                binding.tasbeeh.text = "سبحان الله"
            }

        }
    }

}