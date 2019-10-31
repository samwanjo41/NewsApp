package com.example.prac_news.Network

import com.example.prac_news.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getLatestNews(@Query("sources") source:String, @Query("apiKey")apiKey:String): Call<ResponseModel>
}