package tw.idv.louisli.hashgenerator.util

import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

object BottomNavigationViewMediator {
    fun mediate(viewPager: ViewPager2, bottomNavigationView: BottomNavigationView) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.menu[position].isChecked = true
            }
        })

        bottomNavigationView.setOnItemSelectedListener {
            viewPager.setCurrentItem(it.order, true)
            true
        }
    }
}