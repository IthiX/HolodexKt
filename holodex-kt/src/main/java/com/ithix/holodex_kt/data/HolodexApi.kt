package com.ithix.holodex_kt.data

import com.ithix.holodex_kt.models.ChannelModel
import retrofit2.http.GET
import retrofit2.http.Path

internal interface HolodexApi {

    @GET("/videos")
    suspend fun getVideos()

    @GET("/channels/{channelId}")
    suspend fun getChannelInfo(
        @Path("phoneNumber") channelId: String
    ): ChannelModel
}