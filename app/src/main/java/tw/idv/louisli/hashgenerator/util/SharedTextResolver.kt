package tw.idv.louisli.hashgenerator.util

import android.content.Intent
import android.os.Build
import android.view.View
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import tw.idv.louisli.hashgenerator.R

object SharedTextResolver {
    const val ID_GENERATOR = 0
    const val ID_DECODER = 2

    fun resolve(
        activity: FragmentActivity,
        onShortcutSelected: (shortcutId: Int?, sharedText: String?) -> Unit
    ) {
        val intent = activity.intent
        val isShareText = intent?.action == Intent.ACTION_SEND && intent.type == "text/plain"
        val sharedText = if (isShareText) {
            intent.getStringExtra(Intent.EXTRA_TEXT)
        } else {
            null
        }
        val shortcutId = if (isShareText) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P &&
                intent.hasExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID)
            ) {
                intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID)
            } else {
                displayShortcutChooser(activity, onShortcutSelected, sharedText)
                null
            }
        } else {
            null
        }
        onShortcutSelected(shortcutId?.toInt(), sharedText)
    }

    private fun displayShortcutChooser(
        activity: FragmentActivity,
        onShortcutSelected: (shortcutId: Int?, sharedText: String?) -> Unit,
        sharedText: String?
    ) {
        BottomSheetDialog(activity).apply {
            setContentView(R.layout.bottom_sheet_shortcut_chooser)
            findViewById<View>(R.id.text_shortcut_chooser_generator)
                ?.setOnClickListener { onShortcutSelected(ID_GENERATOR, sharedText) }
            findViewById<View>(R.id.text_shortcut_chooser_decode)
                ?.setOnClickListener { onShortcutSelected(ID_DECODER, sharedText) }
            setCancelable(false)
            show()
        }
    }
}