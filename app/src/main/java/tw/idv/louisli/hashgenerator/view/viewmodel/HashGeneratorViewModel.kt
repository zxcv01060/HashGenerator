package tw.idv.louisli.hashgenerator.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import tw.idv.louisli.hashgenerator.HashGeneratorApplication
import tw.idv.louisli.hashgenerator.algorithm.HashAlgorithmFactory
import tw.idv.louisli.hashgenerator.data.HashHistory
import java.util.*

class HashGeneratorViewModel : ViewModel() {
    val algorithm = MutableStateFlow("MD5")
    val plainText = MutableStateFlow("")
    val salt = MutableStateFlow("")
    val hashResult = MutableStateFlow("")

    private val historyDAO = HashGeneratorApplication.database.hashHistoryDAO

    fun clearPlainTextAndHashResult() {
        plainText.value = ""
        hashResult.value = ""
    }

    fun generate() {
        val hashAlgorithm = HashAlgorithmFactory.create(algorithm.value)
        hashResult.value = hashAlgorithm.hash(plainText.value, salt.value)
        viewModelScope.launch {
            historyDAO.save(createHistory())
        }
    }

    fun createHistory() = HashHistory(
        algorithm = algorithm.value,
        plainText = plainText.value,
        salt = salt.value,
        result = hashResult.value,
        createDate = Date()
    )
}