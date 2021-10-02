package tw.idv.louisli.hashgenerator.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.core.content.getSystemService
import tw.idv.louisli.hashgenerator.data.HashHistory

object ClipboardUtils {
    fun copy(context: Context, history: HashHistory) {
        copy(
            context = context,
            label = "${history.algorithm}: ${history.plainText}" +
                    "(Salt: ${history.salt})",
            content = history.result
        )
    }

    fun copy(context: Context, label: CharSequence, content: CharSequence) {
        val clipboard = context.getSystemService<ClipboardManager>()
        clipboard?.setPrimaryClip(ClipData.newPlainText(label, content))
        notifyUser(context)
    }

    private fun notifyUser(context: Context) {
        Toast.makeText(context, "已複製結果", Toast.LENGTH_SHORT).show()
    }
}