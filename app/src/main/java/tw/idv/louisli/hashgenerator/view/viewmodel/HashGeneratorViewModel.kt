package tw.idv.louisli.hashgenerator.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import tw.idv.louisli.hashgenerator.algorithm.HashAlgorithmFactory

class HashGeneratorViewModel : ViewModel() {
    val algorithm = MutableStateFlow("MD5")
    val plainText = MutableStateFlow("")
    val salt = MutableStateFlow("")
    val hashResult = MutableStateFlow("")

    fun clearPlainTextAndHashResult() {
        plainText.value = ""
        hashResult.value = ""
    }

    fun generate() {
        val hashAlgorithm = HashAlgorithmFactory.create(algorithm.value)
        hashResult.value = hashAlgorithm.hash(plainText.value, salt.value)
    }
}