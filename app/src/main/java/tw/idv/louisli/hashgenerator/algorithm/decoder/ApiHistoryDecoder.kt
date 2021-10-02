package tw.idv.louisli.hashgenerator.algorithm.decoder

import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import tw.idv.louisli.hashgenerator.BuildConfig
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object ApiHistoryDecoder : HashDecoder {
    private const val url = "https://md5decrypt.net/en/Api/api.php"
    private const val email = BuildConfig.API_EMAIL
    private const val code = BuildConfig.API_CODE

    override suspend fun decode(algorithm: String?, ciphertext: String): String? {
        val result = suspendCancellableCoroutine<String> {
            try {
                val url = URL(
                    "$url?email=$email&code=$code&hash=$ciphertext&hash_type=${
                        algorithm?.lowercase()?.replaceFirst("-", "") ?: ""
                    }"
                )
                it.resume(url.readText())
            } catch (e: Exception) {
                e.printStackTrace()
                it.resumeWithException(e)
            }
        }
        return if (result.startsWith("ERROR CODE : ")) {
            Log.e("ApiHistoryDecoder", "找不到對應的明文($algorithm)：$ciphertext")
            null
        } else {
            result
        }
    }
}