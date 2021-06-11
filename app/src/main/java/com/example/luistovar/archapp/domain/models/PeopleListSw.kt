package com.example.luistovar.archapp.domain.models


import com.google.gson.annotations.SerializedName

data class PeopleListSw(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("previous")
    var previous: Any? = null,
    @SerializedName("results")
    var peopleData: List<PeopleData>? = null
)