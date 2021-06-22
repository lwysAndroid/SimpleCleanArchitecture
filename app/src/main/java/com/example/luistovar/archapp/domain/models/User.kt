package com.example.luistovar.archapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String
) : Parcelable
