package com.ithix.holodex_kt.api

import com.ithix.holodex.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

internal class HttpLogger {
    companion object {
        fun createLogger(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()

            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            }

            return interceptor
        }
    }
}