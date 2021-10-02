package tw.idv.louisli.hashgenerator.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.util.BottomNavigationViewMediator.mediate
import tw.idv.louisli.hashgenerator.view.adapter.MainViewPagerAdapter
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager2>(R.id.pager_main)
        pager.adapter = MainViewPagerAdapter(this) {
            pager.setCurrentItem(0, true)
            val hashGeneratorFragment =
                supportFragmentManager.findFragmentByTag("f0") as HashGeneratorFragment
            hashGeneratorFragment.restoreHistory(it)

        }
        pager.mediate(findViewById(R.id.bottom_navigation_main))
    }
}