package tw.idv.louisli.hashgenerator.algorithm

import java.security.MessageDigest

class MessageDigestHashAlgorithm(algorithm: String) : HashAlgorithm {
    private val messageDigest = MessageDigest.getInstance(algorithm)

    override fun hash(plainText: String): String {
        return messageDigest.digest(plainText.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}