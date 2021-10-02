package tw.idv.louisli.hashgenerator.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import tw.idv.louisli.hashgenerator.HashGeneratorApplication
import tw.idv.louisli.hashgenerator.data.HashHistory

class HashHistoryViewModel : ViewModel() {
    val itemList: StateFlow<List<HashHistory>>

    init {
        val historyDAO = HashGeneratorApplication.database.hashHistoryDAO
        itemList = historyDAO.searchAll()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }
}