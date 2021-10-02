package tw.idv.louisli.hashgenerator.view.adapter.viewholder

fun interface ViewHolderFactory<out VH : AdapterViewHolder<*>> {
    fun create(viewType: Int): VH
}