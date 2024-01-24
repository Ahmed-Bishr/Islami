package com.example.islami.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.Adaptor
import com.example.islami.data
import com.example.islami.databinding.ActivityHadeethFragmentBinding
import com.example.islami.hadeethContent
import com.example.islami.hadeeth_Name

class hadeethFragment : Fragment() {

    lateinit var binding: ActivityHadeethFragmentBinding
    lateinit var adapter: Adaptor
    var hadeethList = ArrayList<data>()

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
        addData()
        adapter = Adaptor(hadeethList)
        adapter.OnClickAcion = object : Adaptor.OnTextClick {
            override fun onClick(item: data, position: Int) {
                val intent = Intent(requireContext(), hadeethContent::class.java)
                intent.putExtra("hadeeth_name", item.name)
                intent.putExtra("hadeeth_index", item.index)
                startActivity(intent)
            }
        }
        binding.hadeethView.adapter = adapter
    }

    private fun addData() {
        hadeethList = ArrayList()
        var name = "رقم الحديث"
        for (i in 1..50) {
            hadeethList.add(data(name, i))
        }

    }


}