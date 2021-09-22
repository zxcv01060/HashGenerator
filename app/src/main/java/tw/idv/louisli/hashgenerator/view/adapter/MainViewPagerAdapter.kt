package tw.idv.louisli.hashgenerator.view.adapter

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashHistoryFragment

class MainViewPagerAdapter(private val activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> HashGeneratorFragment(getSharedPlainText())
        1 -> HashHistoryFragment()
        else -> throw IllegalArgumentException("找不到對應的Fragment：$position")
    }

    private fun getSharedPlainText(): String? {
        return activity.intent?.getStringExtra(Intent.EXTRA_TEXT)
    }
}