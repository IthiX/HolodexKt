package com.ithix.holodex_kt.api

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ithix.holodex.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

//TODO Implement Cache
internal class RetrofitClient @Inject constructor(private val authInterceptor: AuthInterceptor) {
    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLogger.createLogger())
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun newInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://holodex.net/api/v2")
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}