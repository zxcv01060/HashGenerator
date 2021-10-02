package tw.idv.louisli.hashgenerator.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem

abstract class BindingAdapterViewHolder<B : ViewDataBinding, in I : AdapterItem> :
    AdapterViewHolder<I> {
    private lateinit var binding: B

    override fun inflateView(inflater: LayoutInflater, parent: ViewGroup?): View {
        this.binding = inflateBinding(inflater, parent)
        return binding.root
    }

    abstract fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup?): B

    override fun bindView(itemView: View) {

    }

    override fun bindItem(item: I) {
        bindItem(binding, item)
    }

    abstract fun bindItem(binding: B, item: I)
}