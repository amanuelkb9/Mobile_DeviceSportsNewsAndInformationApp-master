package com.example.sportsnewsandinformationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.sportsnewsandinformationapp.R
import com.example.sportsnewsandinformationapp.databinding.ItemNewsBinding
import com.example.sportsnewsandinformationapp.model.News

class NewsListAdapter(private val context: Context, private val newsList: List<News>) :
    RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return NewsListViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }


    inner class NewsListViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            binding.newsTitle.text = news.title
            binding.newsDetails.text = news.details

            val requestOptions =
                RequestOptions().placeholder(context.getDrawable(R.drawable.placeholder_image))
                    .error(context.getDrawable(R.drawable.placeholder_image)).diskCacheStrategy(
                        DiskCacheStrategy.ALL
                    )

            Glide.with(context).load(news.imgSrc).apply(requestOptions).into(binding.newsImage)
        }

    }
}