package tw.idv.louisli.hashgenerator.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem

interface AdapterViewHolder<in I : AdapterItem> {
    fun inflateView(inflater: LayoutInflater, parent: ViewGroup?): View

    fun bindView(itemView: View)

    fun bindItem(item: I)
}