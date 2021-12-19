package com.swetajain.dogfacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swetajain.dogfacts.models.Fact
import com.swetajain.dogfacts.repository.FactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FactsViewModel(private val repository: FactsRepository) : ViewModel() {
    //Create a cancellable job
    private var job: Job? = null

    fun getTenFacts() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            repository.getFacts(10)
        }
    }

    fun getAllDatabaseFacts() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            repository.showAllFacts()
        }
    }

    val factsList: LiveData<List<Fact>>
        get() = repository.facts

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}