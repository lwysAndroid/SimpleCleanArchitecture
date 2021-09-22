package com.example.luistovar.archapp.data.datasources.remote.webservices.models


import com.google.gson.annotations.SerializedName

data class PeopleDataResponse(
    @SerializedName("birth_year")
    var birthYear: String? = null,
    @SerializedName("created")
    var created: String? = null,
    @SerializedName("edited")
    var edited: String? = null,
    @SerializedName("eye_color")
    var eyeColor: String? = null,
    @SerializedName("films")
    var films: List<String>? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("hair_color")
    var hairColor: String? = null,
    @SerializedName("height")
    var height: String? = null,
    @SerializedName("homeworld")
    var homeworld: String? = null,
    @SerializedName("mass")
    var mass: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("skin_color")
    var skinColor: String? = null,
    @SerializedName("species")
    var species: List<String>? = null,
    @SerializedName("starships")
    var starships: List<String>? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("vehicles")
    var vehicles: List<String>? = null
)