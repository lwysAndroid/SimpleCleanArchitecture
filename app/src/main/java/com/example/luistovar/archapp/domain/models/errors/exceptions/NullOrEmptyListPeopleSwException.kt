package com.example.luistovar.archapp.domain.models.errors.exceptions

import java.lang.Exception

class NullOrEmptyListPeopleSwException(message: String = "The list of people is empty") :
    Exception(message) {
}