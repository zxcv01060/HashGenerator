package tw.idv.louisli.hashgenerator.view.bindingadapter

import android.content.Context
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.MaterialColors
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.view.DividerItemDecoration
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem
import tw.idv.louisli.hashgenerator.view.adapter.DataBindingRecyclerViewAdapter
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.ViewHolderFactory

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("items", "viewHolderFactory")
fun setItem(view: RecyclerView, items: List<AdapterItem>, viewHolderFactory: ViewHolderFactory<*>) {
    view.adapter = DataBindingRecyclerViewAdapter(items, viewHolderFactory)
}

@BindingAdapter("items", "viewHolderFactory", "itemViewLongClickable")
fun setItem(
    view: RecyclerView,
    items: List<AdapterItem>,
    viewHolderFactory: ViewHolderFactory<*>,
    itemViewLongClickable: Boolean
) {
    view.adapter = DataBindingRecyclerViewAdapter(items, viewHolderFactory, itemViewLongClickable)
}

@BindingAdapter("enableDivider")
fun setDivider(view: RecyclerView, isEnableDivider: Boolean) {
    if (isEnableDivider) {
        setDivider(view, null, null)
    }
}

@BindingAdapter(value = ["dividerColor", "dividerHeight"], requireAll = false)
fun setDivider(view: RecyclerView, @ColorInt color: Int?, height: Int?) {
    @ColorInt
    fun getDefaultColor(context: Context): Int {
        return MaterialColors.getColor(context, R.attr.colorOnBackground, Color.GRAY)
    }

    view.addItemDecoration(
        DividerItemDecoration(
            color ?: getDefaultColor(view.context),
            height ?: 2
        )
    )
}
