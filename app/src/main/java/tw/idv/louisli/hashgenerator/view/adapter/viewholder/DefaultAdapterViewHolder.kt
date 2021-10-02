package tw.idv.louisli.hashgenerator.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem

abstract class DefaultAdapterViewHolder<in I : AdapterItem> : AdapterViewHolder<I> {
    @get:LayoutRes
    abstract val layoutId: Int

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup?): View {
        return inflater.inflate(layoutId, parent, false)
    }
}