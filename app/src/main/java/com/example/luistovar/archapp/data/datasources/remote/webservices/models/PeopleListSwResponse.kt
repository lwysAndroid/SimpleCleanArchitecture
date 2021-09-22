package com.example.luistovar.archapp.data.datasources.remote.webservices.models


import com.google.gson.annotations.SerializedName

data class PeopleListSwResponse(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("previous")
    var previous: Any? = null,
    @SerializedName("results")
    var peopleData: List<PeopleDataResponse>? = null
)