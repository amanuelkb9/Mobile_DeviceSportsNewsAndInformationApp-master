package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsnewsandinformationapp.adapter.EventsListAdapter
import com.example.sportsnewsandinformationapp.databinding.FragmentEventsBinding
import com.example.sportsnewsandinformationapp.model.Event
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.Calendar

class EventsFragment : Fragment(), FragmentWithFAB {
    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!
    private lateinit var eventsList: MutableList<Event>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar1 = Calendar.getInstance()
        calendar1.set(2024, Calendar.MARCH, 10)

        val calendar2 = Calendar.getInstance()
        calendar2.set(2024, Calendar.MARCH, 15)

        eventsList = mutableListOf(
            Event(
                "FIBA Basketball World Cup Qualifiers",
                "Qualifying games for the 2025 FIBA Basketball World Cup",
                calendar1.time
            ),
            Event(
                "Indian Premier League (IPL)",
                "Twenty20 Cricket League in India",
                calendar2.time
            )
        )

        binding.eventsListView.layoutManager = LinearLayoutManager(requireContext())
        binding.eventsListView.adapter = EventsListAdapter(requireContext(), eventsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_event, null)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.add_new_event))
            .setView(dialogView)
            .setPositiveButton(getString(R.string.add_label)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_label)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}