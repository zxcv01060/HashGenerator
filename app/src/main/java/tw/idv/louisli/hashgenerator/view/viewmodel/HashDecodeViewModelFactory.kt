package tw.idv.louisli.hashgenerator.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tw.idv.louisli.hashgenerator.dao.HashHistoryDAO

class HashDecodeViewModelFactory(private val historyDAO: HashHistoryDAO) :
    ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HashDecodeViewModel(historyDAO) as T
    }
}