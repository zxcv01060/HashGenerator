package tw.idv.louisli.hashgenerator.dao

import androidx.room.Dao
import androidx.room.Insert
import tw.idv.louisli.hashgenerator.data.HashHistory

@Dao
interface HashHistoryDAO {
    @Insert
    suspend fun save(history: HashHistory)
}