package com.example.luistovar.archapp.domain.models.errors.exceptions

import java.lang.Exception

class InvalidDataException(message: String = "The required information is not valid") :
    Exception(message) {
}