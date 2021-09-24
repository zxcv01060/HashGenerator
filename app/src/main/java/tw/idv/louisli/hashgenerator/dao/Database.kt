package tw.idv.louisli.hashgenerator.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tw.idv.louisli.hashgenerator.data.HashHistory

@Database(entities = [HashHistory::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract val hashHistoryDAO: HashHistoryDAO
}