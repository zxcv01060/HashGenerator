package tw.idv.louisli.hashgenerator.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.AdapterViewHolder
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.RecyclerViewViewHolderImpl
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.ViewHolderFactory

class DataBindingRecyclerViewAdapter(
    items: List<AdapterItem>,
    private val viewHolderFactory: ViewHolderFactory<AdapterViewHolder<*>>
) : RecyclerView.Adapter<RecyclerViewViewHolderImpl>() {
    private val _items = items.toMutableList()
    val items: List<AdapterItem>
        get() = _items.toList()
    private lateinit var inflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        this.inflater = LayoutInflater.from(recyclerView.context)
    }

    override fun getItemCount(): Int = _items.size

    override fun getItemViewType(position: Int): Int = _items[position].type

    @Suppress("unchecked_cast")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolderImpl {
        val viewHolder = viewHolderFactory.create(viewType)
        val itemView = viewHolder.inflateView(inflater, parent)
        viewHolder.bindView(itemView)
        return RecyclerViewViewHolderImpl(viewHolder as AdapterViewHolder<AdapterItem>, itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolderImpl, position: Int) {
        holder.child.bindItem(_items[position])
    }
}