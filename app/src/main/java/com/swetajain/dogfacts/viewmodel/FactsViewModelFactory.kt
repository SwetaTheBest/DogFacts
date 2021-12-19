package com.swetajain.dogfacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swetajain.dogfacts.repository.FactsRepository

/**
 * A [ViewModelProvider.Factory] that provides dependencies to [FactsViewModel],
 * allowing tests to switch out [FactsDao] implementation via constructor injection.
 */
class FactsViewModelFactory(private val repository: FactsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FactsViewModel(repository) as T
    }
}