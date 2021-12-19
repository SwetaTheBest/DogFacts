package com.swetajain.dogfacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swetajain.dogfacts.repository.FactsRepository

class FactsViewModelFactory(private val repository: FactsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FactsViewModel(repository) as T
    }
}