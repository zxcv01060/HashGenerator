package tw.idv.louisli.hashgenerator.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.view.adapter.AdapterItem
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
) : AdapterItem {
    @field:Ignore
    override val type: Int = R.id.item_type_hash_history
}
