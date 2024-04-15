package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.sportsnewsandinformationapp.adapter.NewsListAdapter
import com.example.sportsnewsandinformationapp.databinding.FragmentNewsBinding
import com.example.sportsnewsandinformationapp.model.News
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class NewsFragment : Fragment(), FragmentWithFAB {
    private var _binding:FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsList: MutableList<News>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsList = mutableListOf(
            News("https://s.yimg.com/ny/api/res/1.2/tFZAIgpggB9NSAE9_6PUCw--/YXBwaWQ9aGlnaGxhbmRlcjt3PTI0MDA7aD0xNjAwO2NmPXdlYnA-/https://s.yimg.com/os/creatr-uploaded-images/2024-03/746bb3e0-edd0-11ee-b677-57a7d0cd4d6f", "NBA playoff races to watch, predictions and first-round matchups we want to see", "It's March Madness in the NBA! With only two weeks left in the regular season, many teams are still fighting for playoff seeding. Which East contender can avoid the Celtics' side of the bracket? Will the Rockets bounce the Warriors from the play-in tournament? Our NBA writers break down the playoff races to watch and make predictions for the stretch run."),
            News("https://www.rappler.com/tachyon/2023/10/justin-brownlee-october-4-2023.jpg?resize=1200%2C806&zoom=1", "FAST FACTS: New-era Gilas Pilipinas begins 2024 FIBA cycle with Asia Cup qualifiers", "MANILA, Philippines – The 2025 FIBA Asia Cup qualifiers mark a new beginning for Gilas Pilipinas.  Besides starting a four-year FIBA cycle, the national team will turn the page on another chapter – now with a permanent head coach, Tim Cone, and a 12-man roster planned to carry the torch until the next World Cup."),
            News("https://cdn.nba.com/manage/2024/02/curry-clippers021424.jpg", "Warriors' Stephen Curry makes NBA history with 7 or more 3s in 4 straight games", "The all-time 3-point leader and 2-time Kia MVP becomes the only player to accomplish the feat.  Stephen Curry made NBA history Wednesday night against the LA Clippers with a 26-foot 3-pointer at the 9-minute mark of the third quarter."),
            News("https://www.si.com/.image/t_share/MTk5NzI4NDAwNTc3ODY0ODA3/1171248.jpg", "Michael Schumacher Health Improving? \"Wouldn't Surprise Me At All\"", "Pat Fry has express cautious optimism about Michael Schumacher's recovery.  Recent discussions in the media have reignited interest in Michael Schumacher's health condition, with former F1 personalities offering insights and hopes for his recovery. Pat Fry in particular expressed optimism about Schumacher's potential progress, given his access to the best medical team and resources."),
            News("https://www.reuters.com/resizer/v2/KCER3RHG2FNBTGV5GXYGGWF7AY.jpg?auth=488ab0e99cb1e85329d37d984abe5da074993d238ce40296466779b6e275d1a1&width=1080&quality=80", "Japan handed 3-0 win after North Korea call off World Cup qualifier", "March 30 (Reuters) - Japan have been awarded a 3-0 victory after North Korea called off a World Cup qualifier between the sides that was scheduled to be held in Pyongyang earlier this month, Japan's Football Association (JFA) said on Saturday.  The JFA said FIFA's Disciplinary Committee had informed them that the match had been forfeited, which means Japan are guaranteed a top-two finish in their group which also includes Syria and Myanmar."),
            News("https://cdn.images.express.co.uk/img/dynamic/72/940x/secondary/jessica-pegula-tennis-5291881.avif?r=1711629028212", "World's richest tennis star adds another £146,000 to incredible net worth at Miami Open", "Jessica Pegula picked up a hefty chunk of prize money despite losing to Ekaterina Alexandrova in the Miami Open quarter-finals on Wednesday. Pegula is technically worth billions as she is poised to inherit the wealth of her father, Terry, who is one of the richest businessmen in the United States."),
            News("https://www.si.com/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_700/MjA0NDM5OTI0NDAzOTM5MTA0/image-placeholder-title.webp", "Manny Pacquiao Recieves Shock Disqualification From Olympic Organizers", "Manny Pacquiao's Olympic dream shattered as age disqualifies him; future fights may be his new focus.  As boxing enthusiasts may remember, living superstar Manny Pacquiao announced last year that he would attempt to compete in the Paris Olympic Games in 2024. Because even though the 45-year-old has been boxing professionally since 1995 and has accomplished a great deal as a professional, he still has, or once had, the desire of representing his nation in the Olympics.")
        )

        binding.newsListView.layoutManager = LinearLayoutManager(requireContext())
        binding.newsListView.adapter = NewsListAdapter(requireContext(), newsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showDialog() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_news, null)

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.add_new_news))
            .setView(dialogView)
            .setPositiveButton(getString(R.string.add_label)) { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancel_label)) { dialog, _ -> dialog.dismiss() }
            .show()
    }
}