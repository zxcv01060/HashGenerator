package tw.idv.louisli.hashgenerator.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashHistoryFragment

class MainViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> HashGeneratorFragment()
        1 -> HashHistoryFragment()
        else -> throw IllegalArgumentException("找不到對應的Fragment：$position")
    }
}