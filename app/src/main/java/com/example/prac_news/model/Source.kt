package com.example.prac_news.model

import com.google.gson.annotations.SerializedName

class Source(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)