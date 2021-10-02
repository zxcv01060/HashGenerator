package tw.idv.louisli.hashgenerator.view.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem

open class RecyclerViewViewHolderImpl(
    val child: AdapterViewHolder<AdapterItem>,
    itemView: View
) : RecyclerView.ViewHolder(itemView)
