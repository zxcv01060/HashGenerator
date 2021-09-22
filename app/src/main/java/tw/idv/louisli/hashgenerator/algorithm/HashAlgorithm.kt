package tw.idv.louisli.hashgenerator.algorithm

fun interface HashAlgorithm {
    fun hash(plainText: String): String = hash(plainText, null)

    fun hash(plainText: String, salt: String?): String
}