package com.example.luistovar.archapp.androidframework.network

import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetWorkConfiguration {
    init {
        getRetrofitClient()
    }

    var retrofit: Retrofit? = null

    private fun getRetrofitClient(): Retrofit {

        return if (retrofit == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit!!
        } else {
            retrofit!!
        }

    }

    fun getStarWarsApi(): StarWarsApi =
        retrofit?.create(StarWarsApi::class.java)!!

}