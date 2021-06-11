package com.example.luistovar.archapp.androidframework.network.webservices

import okhttp3.Interceptor
import okhttp3.Response

class CommonHeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("common_header", "value of common header")
            .addHeader("common_header_wo", "value of common header two")
            .build()
        return chain.proceed(newRequest)

    }
}