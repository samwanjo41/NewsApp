package com.example.prac_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prac_news.Adapter.MainArticleAdapter
import com.example.prac_news.Network.ApiClient
import com.example.prac_news.Network.ApiInterface
import com.example.prac_news.model.Articles
import com.example.prac_news.model.ResponseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val apiService:ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        val call: Call<ResponseModel> = apiService.getLatestNews("techcrunch", API_KEY)

        call.enqueue(object :Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

                Toast.makeText(applicationContext, "Failed to load data"+ t, Toast.LENGTH_LONG).show()
                Log.e("error", "failed"+t)
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
             if(response.body()?.status == "ok"){
                  val articleList:List<Articles> = response.body()!!.articles

                  if(articleList.size>0){
                      val adapter:MainArticleAdapter = MainArticleAdapter(articleList)
                      recyclerView.adapter = adapter
                  }
              }
            }
        })
    }

    companion object {
        private const val API_KEY = "3797771b01aa4ec6bfb85cb4498fc4b1"
    }
}
