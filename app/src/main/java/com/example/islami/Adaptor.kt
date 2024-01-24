package com.example.islami

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.ActivitySuraNameBinding

class Adaptor(var suraIndexItems: ArrayList<data>) : Adapter<Adaptor.appViewHolder>() {

    var OnClickAcion: OnTextClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): appViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ActivitySuraNameBinding.inflate(inflater, parent, false)
        return appViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return suraIndexItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: appViewHolder, position: Int) {
        val items = suraIndexItems?.get(position) ?: return
        holder.viewTheItems(items)
        holder.binding.root.setOnClickListener {
            OnClickAcion?.onClick(items, position)
        }
    }

    interface OnTextClick {
        fun onClick(item: data, position: Int)
    }

    class appViewHolder(var binding: ActivitySuraNameBinding) : ViewHolder(binding.root) {
        fun viewTheItems(item: data) {
            binding.suraName.text = item.name
            binding.suraNumber.text = "${item.index}" // add the int in the brackets to convert to String

        }
    }



}