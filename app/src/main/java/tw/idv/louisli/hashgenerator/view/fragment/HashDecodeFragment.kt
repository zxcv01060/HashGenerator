package tw.idv.louisli.hashgenerator.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import tw.idv.louisli.hashgenerator.HashGeneratorApplication
import tw.idv.louisli.hashgenerator.databinding.FragmentHashDecodeBinding
import tw.idv.louisli.hashgenerator.view.viewmodel.HashDecodeViewModel
import tw.idv.louisli.hashgenerator.view.viewmodel.HashDecodeViewModelFactory

class HashDecodeFragment(private val ciphertext: String?) : Fragment(), ShortcutFragment {
    private lateinit var binding: FragmentHashDecodeBinding
    private val viewModel: HashDecodeViewModel by lazy {
        ViewModelProvider(
            this@HashDecodeFragment,
            HashDecodeViewModelFactory(HashGeneratorApplication.database.hashHistoryDAO)
        ).get()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHashDecodeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@HashDecodeFragment.viewModel.apply {
                ciphertext.value = this@HashDecodeFragment.ciphertext ?: ""
            }
        }
        return binding.root
    }

    override fun onShortcutClick(sharedText: String) {
        viewModel.ciphertext.value = sharedText
    }
}