package com.example.sportsnewsandinformationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnewsandinformationapp.R
import com.example.sportsnewsandinformationapp.databinding.ItemEventBinding
import com.example.sportsnewsandinformationapp.model.Event
import java.text.SimpleDateFormat

class EventsListAdapter(private val context: Context, private val eventsList: List<Event>) :
    RecyclerView.Adapter<EventsListAdapter.EventsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(inflater, parent, false)
        return EventsListViewHolder(binding)
    }

    override fun getItemCount(): Int = eventsList.size

    override fun onBindViewHolder(holder: EventsListViewHolder, position: Int) {
        val event = eventsList[position]
        holder.bind(event)
    }

    inner class EventsListViewHolder(private val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.eventName.text = event.name
            binding.eventDescription.text = event.description
            SimpleDateFormat(context.getString(R.string.events_date_format)).format(event.date)
                .also { binding.eventDate.text = it }
        }
    }
}