package tw.idv.louisli.hashgenerator.view.bindingadapter

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.TAIWAN)

@BindingConversion
fun dateToString(date: Date): String = formatter.format(date)
