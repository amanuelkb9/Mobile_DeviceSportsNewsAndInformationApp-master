package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.sportsnewsandinformationapp.adapter.AthletesListAdapter
import com.example.sportsnewsandinformationapp.databinding.FragmentAthletesBinding
import com.example.sportsnewsandinformationapp.model.Athlete
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AthletesFragment : Fragment(), FragmentWithFAB {
    private var _binding: FragmentAthletesBinding? = null
    private val binding get() = _binding!!
    private lateinit var athletesList: MutableList<Athlete>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAthletesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        athletesList = mutableListOf(
            Athlete(
                "Manny Pacquiao",
                "Boxing",
                "Philippines",
                "He has won world championships in eight different weight divisions, a feat unmatched by any other boxer in history.",
                27,
                "Pacquiao's journey from poverty to boxing superstardom has inspired millions around the world, earning him the nickname \"Pac-Man\" and making him a national hero in the Philippines."
            ),
            Athlete(
                "Michael Jordan",
                "Basketball",
                "United States",
                "Jordan holds the record for the highest career scoring average in NBA history, with 30.12 points per game.",
                75,
                "Michael Jordan's partnership with Nike revolutionized the athletic shoe industry, leading to the creation of the iconic Air Jordan sneakers, which remain highly popular and influential today."
            ),
            Athlete(
                "Stephen Curry",
                "Basketball",
                "United States",
                "Curry is widely regarded as one of the greatest shooters in NBA history, holding numerous three-point shooting records, including most three-pointers made in a single season and most three-pointers made in NBA Finals history.",
                30,
                "Curry's unmatched shooting range and accuracy have transformed the NBA, inspiring a new generation of players to prioritize three-point shooting and revolutionizing offensive strategies."
            ),
            Athlete(
                "Michael Schumacher",
                "Formula One(F1) Racing",
                "Germany",
                "He holds the record for the most Formula One World Championship titles, with seven championships won in total (1994, 1995, 2000, 2001, 2002, 2003, and 2004).",
                17,
                "Schumacher's impact on Formula One racing is immeasurable, as he inspired generations of drivers and fans, and his records continue to be benchmarks for excellence in the sport."
            ),
            Athlete(
                "Lionel Messi",
                "Football (Soccer)",
                "Argentina",
                "He holds the record for the most goals scored for a single club in football history, having scored over 600 goals for FC Barcelona.",
                14,
                "Messi is renowned for his exceptional dribbling skills, close ball control, and intricate footwork, which allow him to maneuver past defenders with ease."
            ),
            Athlete(
                "Michael Phelps",
                "Swimming",
                "United States",
                "He holds the record for the most Olympic medals won by any athlete in history, with a total of 28 Olympic medals (23 gold, 3 silver, and 2 bronze) across five Olympic Games (2000, 2004, 2008, 2012, and 2016).",
                28,
                "Phelps's rigorous training regimen, mental toughness, and dedication to his craft were instrumental in his success, as he constantly pushed the boundaries of what was thought possible in swimming."
            ),
            Athlete(
                "Usain Bolt",
                "Track and Field",
                "Jamaica",
                "He holds the world records for the 100 meters (9.58 seconds) and 200 meters (19.19 seconds), both set at the 2009 World Championships in Berlin, Germany.",
                8,
                "Usain Bolt earned the nickname \"Lightning Bolt\" for his incredible speed and dominance on the track, captivating audiences worldwide with his charismatic personality and showmanship."
            ),
            Athlete(
                "Serena Williams",
                "Tennis",
                "United States",
                "She has won 23 Grand Slam singles titles, the most by any player in the Open Era, and is tied for the record of most Grand Slam singles titles in the Open Era with Margaret Court.",
                23,
                "Serena and her sister Venus Williams have had a significant impact on the sport of tennis, often facing each other in high-profile matches and dominating doubles competitions together."
            )
        )

        binding.athletesListView.layoutManager = LinearLayoutManager(requireContext())
        binding.athletesListView.adapter = AthletesListAdapter(requireContext(), athletesList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_athlete, null)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Add New Athlete")
            .setView(dialogView)
            .setPositiveButton(getString(R.string.add_label)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_label)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}