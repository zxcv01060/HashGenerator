package tw.idv.louisli.hashgenerator.view.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
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
