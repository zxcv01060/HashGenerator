package tw.idv.louisli.hashgenerator.view

import android.content.Context
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ContextMenuRecyclerView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var contextMenuInfo: ContextMenu.ContextMenuInfo

    override fun getContextMenuInfo(): ContextMenu.ContextMenuInfo = contextMenuInfo

    override fun showContextMenuForChild(originalView: View?): Boolean {
        saveContextMenuInfo(originalView)
        return super.showContextMenuForChild(originalView)
    }

    private fun saveContextMenuInfo(child: View?) {
        this.contextMenuInfo = RecyclerViewContextMenuInfo(
            getChildAdapterPosition(child ?: throw IllegalArgumentException("child不能為null")),
            getChildViewHolder(child)
        )
    }

    override fun showContextMenuForChild(originalView: View?, x: Float, y: Float): Boolean {
        saveContextMenuInfo(originalView)
        return super.showContextMenuForChild(originalView, x, y)
    }
}