package tw.idv.louisli.hashgenerator.view.adapter

import androidx.annotation.IdRes
import androidx.room.Ignore

interface AdapterItem {
    @get:IdRes
    @get:Ignore
    val type: Int
}