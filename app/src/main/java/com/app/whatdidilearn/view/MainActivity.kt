package com.app.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.app.whatdidilearn.R
import com.app.whatdidilearn.data.DatabaseItems
import com.app.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        val recyclerView = binding.itemsRecycleView
//        val recyclerView = findViewById<RecyclerView>(R.id.items_recycle_view)

        val adapter = LearnedItemsAdapter()
        recyclerView.adapter = adapter

        val learnedItemsList = DatabaseItems.getAll()
        adapter.data = learnedItemsList
    }
}