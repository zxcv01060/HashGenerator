package tw.idv.louisli.hashgenerator

import android.app.Application
import androidx.room.Room
import tw.idv.louisli.hashgenerator.dao.Database

class HashGeneratorApplication : Application() {
    companion object {
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, Database::class.java, "hash-generator.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}