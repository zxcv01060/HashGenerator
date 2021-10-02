package tw.idv.louisli.hashgenerator.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import tw.idv.louisli.hashgenerator.algorithm.decoder.ApiHistoryDecoder
import tw.idv.louisli.hashgenerator.algorithm.decoder.CompositeHashDecoder
import tw.idv.louisli.hashgenerator.algorithm.decoder.HashDecoder
import tw.idv.louisli.hashgenerator.algorithm.decoder.LocalHistoryDecoder
import tw.idv.louisli.hashgenerator.dao.HashHistoryDAO
import tw.idv.louisli.hashgenerator.data.HashHistory
import java.util.*

class HashDecodeViewModel(private val historyDAO: HashHistoryDAO) : ViewModel() {
    val algorithm = MutableStateFlow("MD5")
    val ciphertext = MutableStateFlow("")
    val plainText = MutableStateFlow("")

    private val hashDecoder: HashDecoder = CompositeHashDecoder(
        LocalHistoryDecoder(historyDAO),
        ApiHistoryDecoder
    )

    fun clearCiphertextAndResult() {
        ciphertext.value = ""
        plainText.value = ""
    }

    fun decode() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = hashDecoder.decode(algorithm.value, ciphertext.value)
            if (result != null) {
                plainText.value = result
                historyDAO.save(
                    HashHistory(
                        algorithm = algorithm.value,
                        plainText = result,
                        salt = "",
                        result = ciphertext.value,
                        createDate = Date()
                    )
                )
            } else {
                plainText.value = "查無結果"
            }
        }
    }
}