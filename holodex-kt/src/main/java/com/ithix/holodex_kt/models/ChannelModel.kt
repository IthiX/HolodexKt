package com.ithix.holodex_kt.models

import com.google.gson.annotations.SerializedName

internal data class ChannelModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("english_name")
    val english_name: String?,
    @SerializedName("org")
    val org: String?,
    @SerializedName("sub_org")
    val sub_org: String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("banner")
    val banner: String?,
    @SerializedName("twitter")
    val twitter: String?,
    @SerializedName("video_count")
    val video_count: String?,
    @SerializedName("subscriber_count")
    val subscriber_count: String?,
    @SerializedName("view_count")
    val view_count: String?,
    @SerializedName("clip_count")
    val clip_count: String?,
    @SerializedName("lang")
    val lang: String?,
    @SerializedName("published_at")
    val published_at: String, //string<date-time> eg: 2021-05-13T15:00:05.766Z
    @SerializedName("inactive")
    val inactive: Boolean,
    @SerializedName("description")
    val description: String,
)
