package com.example.islami

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.databinding.ActivitySuraNameBinding
import com.example.islami.databinding.HadeethNameBinding

class HadeethAdaptor(var hadeethItemIndex: ArrayList<hadeethData>?) :
    Adapter<HadeethAdaptor.appViewHolder>() {

    var onClickAction: onClickHadeeth? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): appViewHolder {
        var context = parent.context
        var inflater =  LayoutInflater.from(context)
        var binding = HadeethNameBinding.inflate(inflater,parent,false)
        return appViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadeethItemIndex?.size ?: 0
    }

    override fun onBindViewHolder(holder: appViewHolder, position: Int) {
        var item = hadeethItemIndex?.get(position) ?: return
        holder.viewTheItems(item)
        holder.binding.root.setOnClickListener {
            onClickAction?.onClick(item, position)
        }
    }
    interface onClickHadeeth {
        fun onClick(item: hadeethData, position: Int)
    }

    class appViewHolder(var binding: HadeethNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun viewTheItems(item: hadeethData) {
            binding.hadeethText.text = item.hadeethName
            binding.hadeethIndex.text = item.hadeethIndex.toString()
        }
    }


}