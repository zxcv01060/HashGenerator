package tw.idv.louisli.hashgenerator.util

import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import tw.idv.louisli.hashgenerator.R

object BottomNavigationViewMediator {
    fun ViewPager2.mediate(bottomNavigationView: BottomNavigationView) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.menu[position].isChecked = true
            }
        })

        bottomNavigationView.setOnItemSelectedListener {
            setCurrentItem(
                when (it.itemId) {
                    R.id.menu_item_main_hash_generator -> 0
                    R.id.menu_item_main_hash_history -> 1
                    else -> throw IllegalStateException("此底部導覽列項目沒有對應的Position")
                },
                true
            )
            true
        }
    }
}