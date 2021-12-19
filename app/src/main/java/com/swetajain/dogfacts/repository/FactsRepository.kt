package com.swetajain.dogfacts.repository

import androidx.lifecycle.MutableLiveData
import com.swetajain.dogfacts.api.ApiInterface.Companion.mServices
import com.swetajain.dogfacts.db.FactsDatabase
import com.swetajain.dogfacts.models.Fact

class FactsRepository(
//    private val apiInterface: ApiInterface,
    private val factsDatabase: FactsDatabase
) {

    private val _factsLiveData = MutableLiveData<List<Fact>>()
    val facts: MutableLiveData<List<Fact>>
        get() = _factsLiveData

    suspend fun getFacts(number: Int) {
        val result = mServices.getFacts(number)
        if (result.isSuccessful) {
            result.body()?.let { factsDatabase.factsDao().addFacts(it) }
            _factsLiveData.postValue(result.body())
        }
    }
}