package tw.idv.louisli.hashgenerator.algorithm

object HashAlgorithmFactory {
    fun create(algorithm: String): HashAlgorithm = MessageDigestHashAlgorithm(algorithm)
}