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
    var count = 0
    var rotation = 93F

    // The onCreateView() method is called when the fragment should create its layout.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using the generated binding class.
        binding = ActivitySebhaFragmentBinding.inflate(inflater)
        return binding.root
    }

    // The onViewCreated() method is called after the fragment's view has been created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countTasbeeh()         // Call the countTasbeeh() method to initialize the tasbeeh counter.
    }

    // The countTasbeeh() method is responsible for updating the
    // tasbeeh counter and changing the text on each button click.
    private fun countTasbeeh() {
        binding.tasbeeh.setOnClickListener {
            onClickMainFunction()

            // Check the count and current tasbeeh text to determine if the text should be changed.
            if (count == 33 && binding.tasbeeh.text == "سبحان الله") {
                resetTheCounter()
                binding.tasbeeh.text = "الله اكبر"

            } else if (count == 33 && binding.tasbeeh.text == "الله اكبر") {
                resetTheCounter()
                binding.tasbeeh.text = "استغفر الله"

            } else if (count == 33 && binding.tasbeeh.text == "استغفر الله") {
                resetTheCounter()
                binding.tasbeeh.text = "الحمد لله"

            } else if (count == 33 && binding.tasbeeh.text == "الحمد لله") {
                resetTheCounter()
                binding.tasbeeh.text = "سبحان الله"
            }
        }
    }

    // reset the counter to zero
    private fun resetTheCounter() {
        count = 0
        binding.tasbeehCount.text = count.toString()
    }

    /* main function when the button is Clicked
    1 - increase the counter by one
    2- rotate the image with 93 degree
    3- change the count text on the tasbeeh count View */
    private fun onClickMainFunction() {
        count++
        rotation += 93F
        binding.body.rotation = rotation
        binding.tasbeehCount.text = count.toString()
    }

}