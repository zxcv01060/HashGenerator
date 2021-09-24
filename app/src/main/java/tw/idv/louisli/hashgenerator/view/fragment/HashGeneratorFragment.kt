package tw.idv.louisli.hashgenerator.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.databinding.FragmentHashGeneratorBinding
import tw.idv.louisli.hashgenerator.util.ClipboardUtils
import tw.idv.louisli.hashgenerator.view.viewmodel.HashGeneratorViewModel

class HashGeneratorFragment(private val sharedPlainText: String? = null) : Fragment() {
    private lateinit var binding: FragmentHashGeneratorBinding
    private val viewModel: HashGeneratorViewModel by lazy { ViewModelProvider(this).get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHashGeneratorBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.plainText.value = sharedPlainText ?: ""
        registerForContextMenu(binding.textHashGeneratorHashResult)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val activity = requireActivity()
        activity.menuInflater.inflate(R.menu.hash_result_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_hash_result_copy -> {
                copyHashResultToClipboard()
                true
            }
            R.id.menu_item_hash_result_share -> {
                shareHashResultToOtherApp()
                true
            }
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

    private fun copyHashResultToClipboard() {
        ClipboardUtils.copy(
            context = requireContext(),
            label = "${viewModel.algorithm.value}: ${viewModel.plainText.value}" +
                    "(Salt: ${viewModel.salt.value})",
            content = viewModel.hashResult.value
        )
    }

    private fun shareHashResultToOtherApp() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, viewModel.hashResult.value)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}