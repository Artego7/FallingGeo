package com.example.fallinggeo.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fallinggeo.R


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4
    )


    // Aquesta funció indica el fragment que s'ha de posar a cada Tab
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> ShopFragment()
            1 -> HistoryModeMenuFragment()
            2 -> InfinityModeMenuFragment()
            3 -> PlaneModeFragment()
            else -> throw IllegalStateException("There's only 4 tabs")
        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 4 total pages.
        return TAB_TITLES.size
    }
}