package tw.idv.louisli.hashgenerator.algorithm

fun interface HashAlgorithm {
    fun hash(plainText: String): String
}