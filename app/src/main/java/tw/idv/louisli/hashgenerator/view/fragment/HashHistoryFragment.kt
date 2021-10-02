package tw.idv.louisli.hashgenerator.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.data.HashHistory
import tw.idv.louisli.hashgenerator.databinding.FragmentHashHistoryBinding
import tw.idv.louisli.hashgenerator.util.ClipboardUtils
import tw.idv.louisli.hashgenerator.view.RecyclerViewContextMenuInfo
import tw.idv.louisli.hashgenerator.view.adapter.DataBindingRecyclerViewAdapter
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.HashHistoryViewHolderFactory
import tw.idv.louisli.hashgenerator.view.viewmodel.HashHistoryViewModel

typealias OpenHashGeneratorCallback = (history: HashHistory) -> Unit

class HashHistoryFragment(
    private val openHashGeneratorCallback: OpenHashGeneratorCallback
) : Fragment() {
    private lateinit var binding: FragmentHashHistoryBinding
    private val viewModel: HashHistoryViewModel by lazy { ViewModelProvider(this).get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHashHistoryBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@HashHistoryFragment.viewModel
            layoutManager = LinearLayoutManager(requireContext())
            viewHolderFactory = HashHistoryViewHolderFactory
        }
        registerForContextMenu(binding.recyclerHashHistory)
        return binding.root
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val activity = requireActivity()
        activity.menuInflater.inflate(R.menu.hash_history_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_hash_history_copy_result -> {
                copyHistoryHashResultToClipboard(resolveHistoryFromContextMenuInfo(item.menuInfo))
                true
            }
            R.id.menu_item_hash_history_other_algorithm -> {
                openHashGeneratorCallback(resolveHistoryFromContextMenuInfo(item.menuInfo))
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun resolveHistoryFromContextMenuInfo(menuInfo: ContextMenu.ContextMenuInfo): HashHistory {
        val recyclerViewContextMenuInfo = menuInfo as RecyclerViewContextMenuInfo
        val adapter = binding.recyclerHashHistory.adapter as DataBindingRecyclerViewAdapter
        return adapter.items[recyclerViewContextMenuInfo.position] as HashHistory
    }

    private fun copyHistoryHashResultToClipboard(history: HashHistory) {
        ClipboardUtils.copy(requireContext(), history)
    }
}