package com.example.luistovar.archapp.domain.models.errors.exceptions

import java.lang.Exception

class NullResponseException(message: String = "Null response from Service") :
    Exception(message) {
}