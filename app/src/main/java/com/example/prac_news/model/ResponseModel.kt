package com.example.prac_news.model

import com.google.gson.annotations.SerializedName

class ResponseModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("articles")
    val articles:List<Articles>
)