package com.app.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.whatdidilearn.data.LearnedItemDao
import com.app.whatdidilearn.entities.LearnedItem

class LearnedItemViewModel(private val dao: LearnedItemDao): ViewModel() {
    val learnedItemList: LiveData<List<LearnedItem>>
    init {
        learnedItemList = dao.getAll()
    }
}