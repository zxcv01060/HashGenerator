package tw.idv.louisli.hashgenerator.view.adapter

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tw.idv.louisli.hashgenerator.view.fragment.HashDecodeFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashHistoryFragment
import tw.idv.louisli.hashgenerator.view.fragment.OpenHashGeneratorCallback

class MainViewPagerAdapter(
    activity: FragmentActivity,
    private val openHashGeneratorCallback: OpenHashGeneratorCallback
) : FragmentStateAdapter(activity) {
    private val intent = activity.intent

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> HashGeneratorFragment(getSharedPlainText())
        1 -> HashHistoryFragment(openHashGeneratorCallback)
        2 -> HashDecodeFragment()
        else -> throw IllegalArgumentException("找不到對應的Fragment：$position")
    }

    private fun getSharedPlainText(): String? {
        return if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            intent.getStringExtra(Intent.EXTRA_TEXT)
        } else {
            null
        }
    }
}