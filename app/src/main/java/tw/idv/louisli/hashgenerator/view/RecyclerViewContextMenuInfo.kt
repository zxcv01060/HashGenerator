package tw.idv.louisli.hashgenerator.view

import android.view.ContextMenu
import androidx.recyclerview.widget.RecyclerView

data class RecyclerViewContextMenuInfo(
    val position: Int,
    val holder: RecyclerView.ViewHolder
) : ContextMenu.ContextMenuInfo
