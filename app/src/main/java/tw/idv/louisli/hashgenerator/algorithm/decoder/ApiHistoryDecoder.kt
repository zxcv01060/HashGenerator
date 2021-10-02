package tw.idv.louisli.hashgenerator.algorithm.decoder

import android.util.Log
import kotlinx.coroutines.suspendCancellableCoroutine
import tw.idv.louisli.hashgenerator.BuildConfig
import java.net.URL

object ApiHistoryDecoder : HashDecoder {
    private const val url = "https://md5decrypt.net/en/Api/api.php"
    private const val email = BuildConfig.API_EMAIL
    private const val code = BuildConfig.API_CODE

    override suspend fun decode(algorithm: String?, ciphertext: String): String? {
        val response = suspendCancellableCoroutine<String> {
            URL(
                "$url?email=$email&code=$code&hash=$ciphertext&hash_type=${
                    algorithm?.lowercase()?.replaceFirst("-", "") ?: ""
                }"
            ).readText()
        }

        Log.d("ApiHistoryDecoder", response)

        return null
    }
}