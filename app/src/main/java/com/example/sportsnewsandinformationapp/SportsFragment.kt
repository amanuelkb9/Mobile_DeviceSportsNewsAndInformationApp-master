package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sportsnewsandinformationapp.adapter.SportsListAdapter
import com.example.sportsnewsandinformationapp.databinding.FragmentSportsBinding
import com.example.sportsnewsandinformationapp.model.Sport
import com.example.sportsnewsandinformationapp.model.SportType
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class SportsFragment : Fragment(), FragmentWithFAB {
    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!
    private lateinit var sportsList: MutableList<Sport>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sportsList = mutableListOf(
            Sport(
                requireContext(),
                SportType.PLAY,
                "Basketball",
                "In basketball, players should focus on honing essential skills such as dribbling, shooting, passing, and rebounding, while also developing a deep understanding of offensive and defensive strategies to excel on the court. Teamwork and communication are crucial in basketball, with players working together to execute plays and outmaneuver opponents."
            ),
            Sport(
                requireContext(),
                SportType.PLAY,
                "Soccer",
                "Soccer players must master fundamental skills like passing, shooting, dribbling, and ball control, while also understanding the nuances of positioning, tactics, and game strategy. Fitness and endurance are essential for soccer players, who must cover large distances on the field and maintain high levels of energy and intensity throughout a match. Both basketball and soccer require teamwork and collaboration, with players relying on each other to achieve success on the field or court."
            ),
            Sport(
                requireContext(),
                SportType.MEASURE,
                "Car Racing",
                "In car racing, safety is paramount; always wear appropriate safety gear and ensure your vehicle meets all safety standards. Familiarize yourself with the rules and regulations of the race event, including track rules, flag signals, and proper racing etiquette. Regular practice sessions are crucial for improving driving skills and mastering race techniques such as cornering, braking, and acceleration. Develop a race strategy based on track conditions, competitor analysis, and pit stop strategies to maximize performance during the race. Show respect for fellow racers, officials, and spectators, and embrace the spirit of sportsmanship both on and off the track."
            ),
            Sport(
                requireContext(),
                SportType.PRECISION,
                "Golf",
                "In golf, mastering the fundamentals is key; focus on achieving a proper grip and balanced stance to lay the foundation for a successful swing. Maintain a smooth and consistent tempo throughout your swing, avoiding any abrupt movements that may compromise your accuracy. Pay careful attention to alignment and aim, ensuring that your body, clubface, and target line are properly aligned for each shot. Practice effective course management by strategizing your approach, taking into account factors like wind, hazards, and terrain to optimize your performance. Cultivate a positive mindset and patience on the course, as golf demands mental resilience and focus alongside physical skill."
            ),
            Sport(
                requireContext(),
                SportType.SPECTACLE,
                "Gymnastics",
                "In gymnastics, beginners should focus on mastering fundamental skills such as rolls and handstands to establish a strong foundation, gradually progressing to more advanced maneuvers while maintaining proper form and technique. Regular training sessions and guidance from experienced coaches are essential for improving flexibility, strength, and balance, all of which are crucial aspects of gymnastics."
            ),
            Sport(
                requireContext(),
                SportType.SPECTACLE,
                "Skate Boarding",
                "Skateboarding enthusiasts should start with the basics of riding and turning, gradually advancing to more complex tricks and maneuvers as they gain confidence and skill. Safety should always be a top priority, with skaters wearing appropriate protective gear and practicing in safe environments to minimize the risk of injury."
            ),
            Sport(
                requireContext(),
                SportType.COMBAT,
                "Boxing",
                "In boxing, newcomers must learn the basic stances and punches, emphasizing proper technique and defensive strategies to protect themselves while effectively engaging with opponents. Endurance and conditioning are also key components of boxing training, with athletes focusing on building stamina and strength to sustain their performance throughout a match."
            )
        )

        binding.sportsListView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.sportsListView.adapter = SportsListAdapter(sportsList)
    }

    override fun showDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_sport, null)
        val spinnerMeasure = dialogView.findViewById<TextInputLayout>(R.id.selectMeasure)
        val measureArray = requireContext().resources.getStringArray(R.array.sport_type_values)
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.item_measure,
            measureArray
        )
        (spinnerMeasure.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.add_new_sport))
            .setView(dialogView)
            .setPositiveButton(getString(R.string.add_label)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_label)) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}