package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsnewsandinformationapp.adapter.HistoryArchiveListAdapter
import com.example.sportsnewsandinformationapp.databinding.FragmentHistoricalSportsArchiveBinding
import com.example.sportsnewsandinformationapp.model.HistoricalSportsArchive
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HistoricalSportsArchiveFragment : Fragment(), FragmentWithFAB {
    private var _binding: FragmentHistoricalSportsArchiveBinding? = null
    private val binding get() = _binding!!
    private lateinit var historyArchiveList: MutableList<HistoricalSportsArchive>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoricalSportsArchiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyArchiveList = mutableListOf(
            HistoricalSportsArchive(
                "First Modern Olympic Games",
                "April 6, 1896",
                "The first modern Olympic Games were held in Athens, Greece, and marked the revival of ancient Olympic Games"
            ),
            HistoricalSportsArchive(
                "Jesse Owens at the 1936 Olympics",
                "August 3-12, 1936",
                "American athlete Jesse Owens won four gold medals in track and field events at the 1936 Berlin Olympics, defying Adolf Hitler's Aryan supremacy ideology"
            )
        )

        binding.historicalSportsArchiveListView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.historicalSportsArchiveListView.adapter =
            HistoryArchiveListAdapter(historyArchiveList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_historical_archive, null)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.add_new_historical_archive))
            .setView(dialogView)
            .setPositiveButton(getString(R.string.add_label)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_label)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}