package tw.idv.louisli.hashgenerator.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.algorithm.HashAlgorithmFactory

class HashGeneratorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hash_generator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textAlgorithm =
            view.findViewById<AutoCompleteTextView>(R.id.text_hash_generator_algorithm_content)
        textAlgorithm.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.support_hash_algorithm)
            )
        )
        val buttonSubmit = view.findViewById<Button>(R.id.button_hash_generator_submit)
        val textPlainText = view.findViewById<TextInputLayout>(R.id.text_hash_generator_plain_text)
        val textHashResult = view.findViewById<TextView>(R.id.text_hash_generator_hash_result)
        buttonSubmit.setOnClickListener {
            val algorithm = HashAlgorithmFactory.create(textAlgorithm.text.toString())
            textHashResult.text = algorithm.hash(textPlainText.editText?.text.toString())
        }
    }
}