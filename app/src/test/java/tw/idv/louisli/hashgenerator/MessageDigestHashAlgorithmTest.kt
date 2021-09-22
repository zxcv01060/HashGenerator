package tw.idv.louisli.hashgenerator

import org.junit.Assert
import org.junit.Test
import tw.idv.louisli.hashgenerator.algorithm.MessageDigestHashAlgorithm

class MessageDigestHashAlgorithmTest {
    private val md5 = MessageDigestHashAlgorithm("MD5")
    private val sha1 = MessageDigestHashAlgorithm("SHA-1")
    private val sha256 = MessageDigestHashAlgorithm("SHA-256")
    private val sha384 = MessageDigestHashAlgorithm("SHA-384")
    private val sha512 = MessageDigestHashAlgorithm("SHA-512")

    @Test
    fun testHashHelloWorldWithMD5() {
        Assert.assertEquals(
            "5eb63bbbe01eeed093cb22bb8f5acdc3",
            md5.hash("hello world")
        )
    }

    @Test
    fun testHashHelloWorldWithSHA1() {
        Assert.assertEquals(
            "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed",
            sha1.hash("hello world")
        )
    }

    @Test
    fun testHashHelloWorldWithSHA256() {
        Assert.assertEquals(
            "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9",
            sha256.hash("hello world")
        )
    }

    @Test
    fun testHashHelloWorldWithSHA384() {
        Assert.assertEquals(
            "fdbd8e75a67f29f701a4e040385e2e23986303ea10239211af907" +
                    "fcbb83578b3e417cb71ce646efd0819dd8c088de1bd",
            sha384.hash("hello world")
        )
    }

    @Test
    fun testHashHelloWorldWithSHA512() {
        Assert.assertEquals(
            "309ecc489c12d6eb4cc40f50c902f2b4d0ed77ee511a7c7a9bcd3c" +
                    "a86d4cd86f989dd35bc5ff499670da34255b45b0cfd830e81f605dcf7dc5542e93ae9cd76f",
            sha512.hash("hello world")
        )
    }
}