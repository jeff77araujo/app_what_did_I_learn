package com.app.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.whatdidilearn.data.LearnedItemDao

class LearnedItemViewModelFactory(private val dao: LearnedItemDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(dao) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}