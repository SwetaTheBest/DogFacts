package com.swetajain.dogfacts.db

import androidx.room.Dao
import androidx.room.Insert
import com.swetajain.dogfacts.models.Fact

/**
 * Database Access Object for the Facts database.
 */
@Dao
interface FactsDao {

    @Insert
    suspend fun addFacts(facts: List<Fact>)

}