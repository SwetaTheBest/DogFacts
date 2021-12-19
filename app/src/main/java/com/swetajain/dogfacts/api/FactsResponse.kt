package com.swetajain.dogfacts.api

import com.google.gson.annotations.SerializedName


class FactsResponseList : ArrayList<FactsResponse>()

data class FactsResponse(
    @SerializedName("fact")
    val fact: String
)