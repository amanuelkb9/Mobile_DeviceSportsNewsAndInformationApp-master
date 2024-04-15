package com.example.sportsnewsandinformationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsnewsandinformationapp.R
import com.example.sportsnewsandinformationapp.databinding.ItemAthleteBinding
import com.example.sportsnewsandinformationapp.model.Athlete

class AthletesListAdapter(private val context: Context, private val athletesList: List<Athlete>) :
    RecyclerView.Adapter<AthletesListAdapter.AthletesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthletesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAthleteBinding.inflate(inflater, parent, false)
        return AthletesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return athletesList.size
    }

    override fun onBindViewHolder(holder: AthletesViewHolder, position: Int) {
        val athlete = athletesList[position]
        holder.bind(athlete)
    }

    inner class AthletesViewHolder(private val binding: ItemAthleteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(athlete: Athlete) {
            binding.athleteName.text = buildString {
                append(context.getString(R.string.name_label))
                append(
                    context.getString(
                        R.string.field_input,
                        athlete.name
                    )
                )
            }
            binding.athleteSport.text = buildString {
                append(context.getString(R.string.sport_label))
                append(
                    context.getString(
                        R.string.field_input,
                        athlete.sport
                    )
                )
            }
            binding.athleteCountry.text =
                buildString {
                    append(context.getString(R.string.country_label))
                    append(
                        context.getString(
                            R.string.field_input,
                            athlete.country
                        )
                    )
                }
            binding.athletePersonalBest.text =
                buildString {
                    append(context.getString(R.string.personal_best_label))
                    append(
                        context.getString(
                            R.string.field_input,
                            athlete.personalBest
                        )
                    )
                }
            binding.athleteMedalsAwarded.text =
                buildString {
                    append(context.getString(R.string.medals_awarded_label))
                    append(
                        context.getString(
                            R.string.field_input,
                            athlete.medalsAwarded.toString()
                        )
                    )
                }
            binding.athleteFacts.text = buildString {
                append(context.getString(R.string.facts_label))
                append(
                    context.getString(
                        R.string.field_input,
                        athlete.facts
                    )
                )
            }
        }

    }
}