package com.example.customviews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customviews.databinding.AnimationListLayoutBinding
import com.example.customviews.models.RocketAnimationItem

class RocketAdapter(private val context: Context) : RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

  private var items = mutableListOf<RocketAnimationItem>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
    val dataHolder = AnimationListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RocketViewHolder(dataHolder)
  }

  override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {

    holder.bind()
  }
  override fun getItemCount(): Int = items.size

  inner class RocketViewHolder(private val binding: AnimationListLayoutBinding): RecyclerView.ViewHolder(binding.root){
    private lateinit var dataModel: RocketAnimationItem
    fun bind(){
      dataModel = items[adapterPosition]
      binding.title.text = dataModel.title
      binding.root.setOnClickListener {
        setTitleOnClickListener(context, items)
      }
    }

    private fun setTitleOnClickListener(context: Context, items: List<RocketAnimationItem>) {
        context.startActivity(items[adapterPosition].intent)
    }

  }

  fun setData(data: List<RocketAnimationItem>?){
    items.clear()
    if (data != null) {
      items.addAll(data)
      notifyDataSetChanged()
    }
  }
}
