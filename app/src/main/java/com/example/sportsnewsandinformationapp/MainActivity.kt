package com.example.sportsnewsandinformationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportsnewsandinformationapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(
            SportsFragment(),
            NewsFragment(),
            AthletesFragment(),
            EventsFragment(),
            HistoricalSportsArchiveFragment(),
            AboutMeFragment()
        )

        val viewPager = binding.mainFragmentHolder
        viewPager.adapter = MainFragmentAdapter(fragments, this)
        binding.mainTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val tabLayout = binding.mainTabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.sports_label)
                1 -> tab.text = getString(R.string.news_label)
                2 -> tab.text = getString(R.string.athletes_label)
                3 -> tab.text = getString(R.string.events_label)
                4 -> tab.text = getString(R.string.historical_archives_label)
                5 -> tab.text = getString(R.string.about_me_label)
            }

        }.attach()

        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_news -> viewPager.setCurrentItem(1, false)
                R.id.menu_events -> viewPager.setCurrentItem(3, false)
                R.id.menu_historical_archives -> viewPager.setCurrentItem(4, false)
            }
            true
        }

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val adapter = viewPager.adapter as? MainFragmentAdapter
                val currentFragment = adapter!!.fragments[viewPager.currentItem]
                if (currentFragment is FragmentWithFAB) binding.floatingActionButton.show()
                else binding.floatingActionButton.hide()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        binding.floatingActionButton.setOnClickListener {
            val adapter = viewPager.adapter as? MainFragmentAdapter
            val currentFragment = adapter!!.fragments[viewPager.currentItem]
            if (currentFragment is FragmentWithFAB) currentFragment.showDialog()
        }
    }

    private inner class MainFragmentAdapter(
        val fragments: List<Fragment>,
        activity: AppCompatActivity
    ) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}
