package com.swetajain.dogfacts.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Data class that represents our items.
 */
@Entity
class Fact(

    @PrimaryKey(autoGenerate = true)
    val factId: Int,
//    @ColumnInfo(name = "fact")
    @SerializedName("fact")
    val fact: String
)
