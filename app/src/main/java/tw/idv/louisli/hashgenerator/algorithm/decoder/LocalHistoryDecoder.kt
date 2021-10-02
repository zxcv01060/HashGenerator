package tw.idv.louisli.hashgenerator.algorithm.decoder

import tw.idv.louisli.hashgenerator.dao.HashHistoryDAO

class LocalHistoryDecoder(private val hashHistoryDAO: HashHistoryDAO) : HashDecoder {

    override suspend fun decode(algorithm: String?, ciphertext: String): String? {
        return hashHistoryDAO.getFirstByAlgorithmAndResult(algorithm, ciphertext)
    }
}