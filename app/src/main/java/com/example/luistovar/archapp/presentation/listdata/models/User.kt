package com.example.luistovar.archapp.presentation.listdata.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String
) : Parcelable
