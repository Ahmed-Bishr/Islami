package com.example.islami

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.SuraDataFileBinding

class fileViewAdaptor(var fileData: List<String>?) : Adapter<fileViewAdaptor.dataviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataviewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = SuraDataFileBinding.inflate(inflater)
        return dataviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fileData?.size ?: 0
    }

    fun adaptorUpdate(fileData : List<String>){
        this.fileData = fileData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: dataviewHolder, position: Int) {
        holder.bind(fileData!![position])
    }

    class dataviewHolder(var binding: SuraDataFileBinding) : ViewHolder(binding.root) {
        fun bind(dataFromFile: String) {
            binding.suraText.text = dataFromFile
        }
    }


}