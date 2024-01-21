package com.example.islami.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Adaptor
import com.example.islami.data

import com.example.islami.databinding.ActivityQuranFragmentBinding
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
        binding.suraView.adapter = adaptor
    }


}