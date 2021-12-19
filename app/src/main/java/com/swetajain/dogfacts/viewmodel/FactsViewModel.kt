package com.swetajain.dogfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swetajain.dogfacts.models.Fact
import com.swetajain.dogfacts.repository.FactsRepository
import kotlinx.coroutines.launch

class FactsViewModel(private val repository: FactsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getFacts(10)
        }
    }

    val fact: LiveData<List<Fact>>
        get() = repository.facts
}