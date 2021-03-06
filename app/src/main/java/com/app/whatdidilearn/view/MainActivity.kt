package com.app.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.app.whatdidilearn.R
import com.app.whatdidilearn.data.DatabaseItems
import com.app.whatdidilearn.databinding.ActivityMainBinding
import com.app.whatdidilearn.viewmodel.LearnedItemViewModel
import com.app.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

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

        val database = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()

        val viewModelFactory = LearnedItemViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(LearnedItemViewModel::class.java)

        val itemsList = viewModel.learnedItemList
        itemsList.observe(this, Observer { items -> adapter.data = items })

        binding.newItemButton.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }
    }
}