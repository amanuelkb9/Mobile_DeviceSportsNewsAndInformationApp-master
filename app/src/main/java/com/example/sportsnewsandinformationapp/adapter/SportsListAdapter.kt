package com.example.sportsnewsandinformationapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnewsandinformationapp.databinding.ItemSportBinding
import com.example.sportsnewsandinformationapp.model.Sport

class SportsListAdapter(private val sportsList: List<Sport>) :
    RecyclerView.Adapter<SportsListAdapter.SportsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSportBinding.inflate(inflater, parent, false)
        return SportsListViewHolder(binding)
    }

    override fun getItemCount(): Int = sportsList.size

    override fun onBindViewHolder(holder: SportsListViewHolder, position: Int) {
        val sport = sportsList[position]
        holder.bind(sport)
    }

    inner class SportsListViewHolder(private val binding: ItemSportBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sport: Sport) {
            binding.sportType.text = sport.type.getString()
            binding.sportName.text = sport.name
            binding.sportInstruction.text = sport.instruction
        }

    }
}