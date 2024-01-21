package com.example.islami.Fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Adaptor
import com.example.islami.data

import com.example.islami.databinding.ActivityQuranFragmentBinding
import com.example.islami.suraContext
import com.example.islami.suraNamesList

class QuranFragment : Fragment() {

    lateinit var binding: ActivityQuranFragmentBinding
    lateinit var adaptor: Adaptor
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityQuranFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val suraList = suraNamesList.mapIndexed { position, item ->
            data(item, position + 1)
        }

        adaptor = Adaptor(suraList)
        adaptor.OnClickAcion = object : Adaptor.OnSuraClick {
            override fun onClick(item: data, position: Int) {
                val intent = Intent(requireContext(), suraContext::class.java)
                intent.putExtra("sura_name", item.suraName)
                intent.putExtra("sura_position", item.suraNumber)
                startActivity(intent)
            }
        }

        binding.suraView.adapter = adaptor
    }


}