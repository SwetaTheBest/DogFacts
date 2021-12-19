package com.swetajain.dogfacts

import android.app.Application
import com.swetajain.dogfacts.db.FactsDatabase
import com.swetajain.dogfacts.repository.FactsRepository

class FactsApplication : Application() {

    lateinit var factsRepository: FactsRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

//        val factsService = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val factsDatabase = FactsDatabase.getDatabase(applicationContext)
        factsRepository = FactsRepository(factsDatabase)
    }
}