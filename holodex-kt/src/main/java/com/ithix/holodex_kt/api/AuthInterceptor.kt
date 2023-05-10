package com.ithix.holodex_kt.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class AuthInterceptor @Inject constructor(private val holoToken: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
//        requestBuilder.addHeader("Authorization", "Bearer $holoToken")
        requestBuilder.addHeader("X-APIKEY", holoToken)
        val request = requestBuilder.build()
        val response = chain.proceed(request)
        if (response.code == 401) {
            Log.e("HOLODEX", "API KEY ERROR")
        }
        return response
    }
}
//TODO Improve API Errors Validation