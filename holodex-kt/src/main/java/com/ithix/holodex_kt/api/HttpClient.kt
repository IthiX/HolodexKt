package com.ithix.holodex_kt.api

import retrofit2.Retrofit

internal class HttpClient(private val retrofit: Retrofit) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}