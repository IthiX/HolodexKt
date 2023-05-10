package com.ithix.holodex_kt.injection

import android.content.Context
import com.ithix.holodex_kt.api.AuthInterceptor
import com.ithix.holodex_kt.api.RetrofitClient
import com.ithix.holodex_kt.data.HolodexApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class HolodexModule(private val holoToken: String) {

    @Provides
    @Singleton
    fun providesToken(): String {
        return holoToken
    }

    @Provides
    fun providesRetrofit(): RetrofitClient {
        return RetrofitClient(AuthInterceptor(holoToken))
    }

    @Provides
    fun provideHolodexApi(): HolodexApi {
        return RetrofitClient(AuthInterceptor(holoToken)).newInstance()
            .create(HolodexApi::class.java)
    }
}