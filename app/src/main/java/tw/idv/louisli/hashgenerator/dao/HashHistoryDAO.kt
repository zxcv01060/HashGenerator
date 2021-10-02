package tw.idv.louisli.hashgenerator.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tw.idv.louisli.hashgenerator.data.HashHistory

@Dao
interface HashHistoryDAO {
    @Insert
    suspend fun save(history: HashHistory)

    @Query("SELECT * FROM HashHistory ORDER BY id DESC")
    fun searchAll(): Flow<List<HashHistory>>

    @Query("SELECT plainText FROM HashHistory WHERE (:algorithm IS NULL OR algorithm = :algorithm) AND result = :result LIMIT 0, 1")
    suspend fun getFirstByAlgorithmAndResult(algorithm: String?, result: String): String?
}