package tw.idv.louisli.hashgenerator.algorithm.decoder

class CompositeHashDecoder(private vararg val decoders: HashDecoder) : HashDecoder {

    override suspend fun decode(algorithm: String?, ciphertext: String): String? {
        return decoders.mapNotNull { it.decode(algorithm, ciphertext) }
            .firstOrNull()
    }
}