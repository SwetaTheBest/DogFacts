package com.swetajain.dogfacts.repository

import androidx.lifecycle.MutableLiveData
import com.swetajain.dogfacts.api.ApiInterface.Companion.mServices
import com.swetajain.dogfacts.db.FactsDatabase
import com.swetajain.dogfacts.models.Fact


/**
 * A repository which provides resource from local database as well as remote end point.
 *
 */
class FactsRepository(
    private val factsDatabase: FactsDatabase
) {

    private val _factsLiveData = MutableLiveData<List<Fact>>()
    val facts: MutableLiveData<List<Fact>>
        get() = _factsLiveData

    suspend fun getFacts(number: Int) {
        val result = mServices.getFacts(number)
        if (result.isSuccessful) {
            result.body()?.let { factsDatabase.factsDao().addFacts(it) }
            showAllFacts()
        }
    }

    suspend fun showAllFacts() {
        val list = factsDatabase.factsDao().readAllData()
        _factsLiveData.postValue(list)
    }
}