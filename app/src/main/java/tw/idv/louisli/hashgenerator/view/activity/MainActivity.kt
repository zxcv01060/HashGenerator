package tw.idv.louisli.hashgenerator.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.Person
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.viewpager2.widget.ViewPager2
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.util.BottomNavigationViewMediator.mediate
import tw.idv.louisli.hashgenerator.util.SharedTextResolver
import tw.idv.louisli.hashgenerator.view.adapter.MainViewPagerAdapter
import tw.idv.louisli.hashgenerator.view.fragment.HashGeneratorFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager(findViewById(R.id.pager_main))
        createShortcut()
    }

    private fun setupViewPager(pager: ViewPager2) {
        pager.mediate(findViewById(R.id.bottom_navigation_main))
        SharedTextResolver.resolve(this) { shortcutId, sharedText ->
            pager.adapter = MainViewPagerAdapter(this, shortcutId, sharedText) {
                pager.setCurrentItem(0, true)
                val hashGeneratorFragment =
                    supportFragmentManager.findFragmentByTag("f0") as HashGeneratorFragment
                hashGeneratorFragment.restoreHistory(it)
            }
            pager.setCurrentItem(shortcutId ?: 0, true)
        }
    }

    private fun createShortcut() {
        ShortcutManagerCompat.addDynamicShortcuts(
            this,
            listOf(createGeneratorInfo(), createDecoderInfo())
        )
    }

    private fun createGeneratorInfo() =
        ShortcutInfoCompat.Builder(this, SharedTextResolver.ID_GENERATOR.toString())
            .setShortLabel("加密")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_baseline_lock_24))
            .setIntent(Intent(Intent.ACTION_DEFAULT))
            .setCategories(setOf("tw.idv.louisli.hashgenerator.category.TEXT_SHARE_TARGET"))
            .setLongLived(true)
            .setPerson(Person.Builder().setName("加密").build())
            .build()

    private fun createDecoderInfo() =
        ShortcutInfoCompat.Builder(this, SharedTextResolver.ID_DECODER.toString())
            .setShortLabel("解密")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_round_lock_open_24))
            .setIntent(Intent(Intent.ACTION_DEFAULT))
            .setCategories(setOf("tw.idv.louisli.hashgenerator.category.TEXT_SHARE_TARGET"))
            .setLongLived(true)
            .setPerson(Person.Builder().setName("解密").build())
            .build()
}