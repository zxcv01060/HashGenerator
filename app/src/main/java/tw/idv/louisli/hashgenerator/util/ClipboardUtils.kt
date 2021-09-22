package tw.idv.louisli.hashgenerator.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.core.content.getSystemService

object ClipboardUtils {
    fun copy(context: Context, label: CharSequence, content: CharSequence) {
        val clipboard = context.getSystemService<ClipboardManager>()
        clipboard?.setPrimaryClip(ClipData.newPlainText(label, content))
        notifyUser(context)
    }

    private fun notifyUser(context: Context) {
        Toast.makeText(context, "已複製結果", Toast.LENGTH_SHORT).show()
    }
}