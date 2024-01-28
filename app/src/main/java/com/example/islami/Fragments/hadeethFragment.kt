package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Adaptor
import com.example.islami.HadeethAdaptor
import com.example.islami.data
import com.example.islami.databinding.ActivityHadeethFragmentBinding
import com.example.islami.fileViewAdaptor
import com.example.islami.hadeethContent
import com.example.islami.hadeethData
import com.example.islami.hadeethList
import com.example.islami.suraContext
import com.example.islami.suraNamesList

class hadeethFragment : Fragment() {

    lateinit var binding: ActivityHadeethFragmentBinding
    lateinit var adapter: HadeethAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityHadeethFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hadeethList = ArrayList(hadeethList.mapIndexed { position, item ->
            hadeethData(item, position + 1)
        })

        adapter = HadeethAdaptor(hadeethList)
        adapter.onClickAction = object : HadeethAdaptor.onClickHadeeth {
            override fun onClick(item: hadeethData, position: Int) {
                val intent = Intent(requireContext(), hadeethContent::class.java)
                intent.putExtra("hadeethname", item.hadeethName)
                intent.putExtra("hadeethposition", item.hadeethIndex)
                startActivity(intent)
            }
        }
        binding.hadeethView.adapter = adapter
    }
}
