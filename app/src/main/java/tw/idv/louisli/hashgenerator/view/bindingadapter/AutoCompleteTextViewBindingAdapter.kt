package tw.idv.louisli.hashgenerator.view.bindingadapter

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter

@BindingAdapter("items")
fun setAdapter(view: AutoCompleteTextView, items: Array<String>) {
    view.setAdapter(
        ArrayAdapter(
            view.context,
            android.R.layout.simple_dropdown_item_1line,
            items
        )
    )
}

@BindingAdapter("android:text")
fun setText(view: AutoCompleteTextView, text: String) {
    view.setText(text, false)
}
