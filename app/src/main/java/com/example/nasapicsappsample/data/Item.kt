package com.example.nasapicsappsample.data

import com.google.gson.annotations.SerializedName

data class Item(
    var copyright: String = "",
    var date: String = "",
    var explanation: String = "",
    @SerializedName("hdurl")
    var hdUrl: String = "",
    @SerializedName("media_type")
    var mediaType: String = "",
    @SerializedName("service_version")
    var serviceVersion: String = "",
    var title: String = "",
    var url: String = "",
)
