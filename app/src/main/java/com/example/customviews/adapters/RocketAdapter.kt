package com.example.customviews.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customviews.databinding.AnimationListLayoutBinding
import com.example.customviews.interfaces.SetOnClickListener
import com.example.customviews.models.RocketAnimationItem

class RocketAdapter: RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

    private var items = mutableListOf<RocketAnimationItem>()
    private var onClick: ((id: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val dataHolder = AnimationListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RocketViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) = holder.bind(items[position], onClick!!)

    override fun getItemCount(): Int = items.size

    class RocketViewHolder(private val binding: AnimationListLayoutBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: RocketAnimationItem, onClick: (id: Int) -> Unit){
            binding.data = data
            binding.root.setOnClickListener{
                onClick.invoke(data.intent)
            }
        }
    }

    fun setData(data: List<RocketAnimationItem>?){
        items.clear()
        if (data != null) {
            items.addAll(data)
            notifyDataSetChanged()
        }
    }

    fun onClickListener(onClick: (id: Int) -> Unit){
        this.onClick = onClick
    }
}