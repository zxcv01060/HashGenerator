package tw.idv.louisli.hashgenerator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import tw.idv.louisli.hashgenerator.util.BottomNavigationViewMediator
import tw.idv.louisli.hashgenerator.view.adapter.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager2>(R.id.pager_main)
        pager.adapter = MainViewPagerAdapter(this)
        BottomNavigationViewMediator.mediate(pager, findViewById(R.id.bottom_navigation_main))
    }
}