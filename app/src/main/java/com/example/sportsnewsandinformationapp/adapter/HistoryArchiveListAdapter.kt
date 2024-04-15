package com.example.sportsnewsandinformationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnewsandinformationapp.databinding.ItemHistoricalSportsArchiveBinding
import com.example.sportsnewsandinformationapp.model.HistoricalSportsArchive

class HistoryArchiveListAdapter(
    private val historyArchiveList: List<HistoricalSportsArchive>
) :
    RecyclerView.Adapter<HistoryArchiveListAdapter.HistoryArchiveViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryArchiveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoricalSportsArchiveBinding.inflate(inflater, parent, false)
        return HistoryArchiveViewHolder(binding)
    }

    override fun getItemCount(): Int = historyArchiveList.size

    override fun onBindViewHolder(holder: HistoryArchiveViewHolder, position: Int) {
        val historyArchive = historyArchiveList[position]
        holder.bind(historyArchive)
    }

    inner class HistoryArchiveViewHolder(private val binding: ItemHistoricalSportsArchiveBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyArchive: HistoricalSportsArchive) {
            binding.historyName.text = historyArchive.name
            binding.historyDate.text = historyArchive.dateOrDateRange
            binding.historyDescription.text = historyArchive.description
        }

    }
}