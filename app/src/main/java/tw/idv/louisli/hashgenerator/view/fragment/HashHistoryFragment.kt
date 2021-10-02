package tw.idv.louisli.hashgenerator.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import tw.idv.louisli.hashgenerator.databinding.FragmentHashHistoryBinding
import tw.idv.louisli.hashgenerator.view.adapter.viewholder.HashHistoryViewHolderFactory
import tw.idv.louisli.hashgenerator.view.viewmodel.HashHistoryViewModel

class HashHistoryFragment : Fragment() {
    private lateinit var binding: FragmentHashHistoryBinding
    private val viewModel: HashHistoryViewModel by lazy { ViewModelProvider(this).get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHashHistoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.layoutManager = LinearLayoutManager(requireContext())
        binding.viewHolderFactory = HashHistoryViewHolderFactory
        return binding.root
    }
}