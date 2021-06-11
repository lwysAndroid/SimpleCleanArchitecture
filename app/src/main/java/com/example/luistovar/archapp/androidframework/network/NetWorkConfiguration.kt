package com.example.luistovar.archapp.androidframework.network

import com.example.luistovar.archapp.BuildConfig
import com.example.luistovar.archapp.androidframework.network.webservices.CommonHeadersInterceptor
import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetWorkConfiguration {
    init {
        getRetrofitClient()
    }

    private const val READ_TIME_OUT: Long = 60
    private const val CONECTION_TIME_OUT: Long = 60

    private var retrofit: Retrofit? = null

    private fun getRetrofitClient(): Retrofit {

        return if (retrofit == null) {
            val clientBuilder = getOkHttpClientBuilder()

            retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit!!
        } else {
            retrofit!!
        }

    }

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {
        val interceptor = getLoggingInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(CommonHeadersInterceptor())
            .readTimeout(READ_TIME_OUT,TimeUnit.SECONDS)
            .connectTimeout(CONECTION_TIME_OUT,TimeUnit.SECONDS)
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    fun getStarWarsApi(): StarWarsApi =
        retrofit?.create(StarWarsApi::class.java)!!

}