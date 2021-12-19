package com.swetajain.dogfacts.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.swetajain.dogfacts.models.Fact

/**
 * Database Access Object for the Facts database.
 */
@Dao
interface FactsDao {

    @Insert
    suspend fun addFacts(facts: List<Fact>)


    @Query("SELECT * FROM Fact")
    fun readAllData(): List<Fact>
}