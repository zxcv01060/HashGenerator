package tw.idv.louisli.hashgenerator.algorithm.decoder

fun interface HashDecoder {
    suspend fun decode(ciphertext: String) = decode(null, ciphertext)

    suspend fun decode(algorithm: String?, ciphertext: String): String?
}