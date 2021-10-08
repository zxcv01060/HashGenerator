package tw.idv.louisli.hashgenerator.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tw.idv.louisli.hashgenerator.util.SharedTextResolver
import tw.idv.louisli.hashgenerator.view.fragment.HashDecodeFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment
import tw.idv.louisli.hashgenerator.view.fragment.HashHistoryFragment
import tw.idv.louisli.hashgenerator.view.fragment.OpenHashGeneratorCallback

class MainViewPagerAdapter(
    activity: FragmentActivity,
    private var shortcutId: Int?,
    private var sharedText: String?,
    private val openHashGeneratorCallback: OpenHashGeneratorCallback
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> HashGeneratorFragment(
            if (shortcutId == SharedTextResolver.ID_GENERATOR) {
                sharedText
            } else {
                null
            }
        )
        1 -> HashHistoryFragment(openHashGeneratorCallback)
        2 -> HashDecodeFragment(
            if (shortcutId == SharedTextResolver.ID_DECODER) {
                sharedText
            } else {
                null
            }
        )
        else -> throw IllegalArgumentException("找不到對應的Fragment：$position")
    }
}