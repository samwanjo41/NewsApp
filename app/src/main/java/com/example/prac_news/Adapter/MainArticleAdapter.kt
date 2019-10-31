package com.example.prac_news.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prac_news.R
import com.example.prac_news.model.Articles
import kotlinx.android.synthetic.main.articles_list_item.view.*

class MainArticleAdapter(val articleList:List<Articles>): RecyclerView.Adapter<MainArticleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val title = itemView.article_adapter_tv_title
        val description = itemView.article_adapter_tv_description
        val parent = itemView.parent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainArticleAdapter.ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.articles_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return articleList.size
    }

    override fun onBindViewHolder(holder: MainArticleAdapter.ViewHolder, position: Int) {
      val model = articleList[position]
        holder.title.text = model.title
        holder.description.text = model.description

    }
}