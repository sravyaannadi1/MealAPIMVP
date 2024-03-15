package com.training.practice1.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.training.practice1.databinding.ItemMealBinding

class MealAdapter(private val context: Context, private val item: ArrayList<MealDetails>):RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    inner class MealViewHolder(val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MealDetails) {
            binding.idmeal.text = item.idmeal
            binding.strmeal.text = item.strmeal
            Picasso.get().load(item.thumb).into(binding.idthumb)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
       val binding=ItemMealBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
       val citem=item[position]
        return holder.bind(citem)
    }

    override fun getItemCount()=item.size
}