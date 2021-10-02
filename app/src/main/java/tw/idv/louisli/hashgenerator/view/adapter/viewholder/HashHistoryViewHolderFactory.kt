package tw.idv.louisli.hashgenerator.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import tw.idv.louisli.hashgenerator.data.HashHistory
import tw.idv.louisli.hashgenerator.databinding.RecyclerItemHashHistoryBinding

object HashHistoryViewHolderFactory : ViewHolderFactory<HashHistoryViewHolderFactory.ViewHolder> {
    override fun create(viewType: Int): ViewHolder {
        return ViewHolder()
    }

    class ViewHolder : BindingAdapterViewHolder<RecyclerItemHashHistoryBinding, HashHistory>() {
        override fun inflateBinding(
            inflater: LayoutInflater,
            parent: ViewGroup?
        ): RecyclerItemHashHistoryBinding {
            return RecyclerItemHashHistoryBinding.inflate(inflater, parent, false)
        }

        override fun bindItem(binding: RecyclerItemHashHistoryBinding, item: HashHistory) {
            binding.hashHistory = item
        }
    }
}