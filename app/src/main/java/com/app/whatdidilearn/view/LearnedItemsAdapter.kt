package com.app.whatdidilearn.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.whatdidilearn.entities.ItemLearned

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {
    var data = listOf<ItemLearned>()
    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size // retorna a quantidade de Itens que o RecycleView está renderizando
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}