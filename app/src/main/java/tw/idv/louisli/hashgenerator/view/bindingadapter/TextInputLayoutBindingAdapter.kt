package tw.idv.louisli.hashgenerator.view.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("endIconOnClick")
fun setEndIconOnClickListener(view: TextInputLayout, listener: View.OnClickListener) {
    view.setEndIconOnClickListener(listener)
}
