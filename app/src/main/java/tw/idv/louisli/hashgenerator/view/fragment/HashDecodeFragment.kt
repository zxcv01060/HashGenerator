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
import tw.idv.louisli.hashgenerator.view.viewmodel.HashDecodeViewModelFactory

class HashDecodeFragment : Fragment() {
    private lateinit var binding: FragmentHashDecodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHashDecodeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = ViewModelProvider(
                this@HashDecodeFragment,
                HashDecodeViewModelFactory(HashGeneratorApplication.database.hashHistoryDAO)
            ).get()
        }
        return binding.root
    }
}