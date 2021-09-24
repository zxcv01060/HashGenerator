package tw.idv.louisli.hashgenerator.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class HashHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val algorithm: String,
    val plainText: String,
    val salt: String,
    val result: String,
    val createDate: Date
)
