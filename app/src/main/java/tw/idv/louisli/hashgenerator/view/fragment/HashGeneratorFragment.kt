package tw.idv.louisli.hashgenerator.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.algorithm.HashAlgorithmFactory
import tw.idv.louisli.hashgenerator.util.ClipboardUtils

class HashGeneratorFragment : Fragment() {
    private lateinit var textAlgorithm: AutoCompleteTextView
    private lateinit var textPlainText: TextInputLayout
    private lateinit var textHashResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hash_generator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textAlgorithm = view.findViewById(R.id.text_hash_generator_algorithm_content)
        textAlgorithm.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.support_hash_algorithm)
            )
        )
        textPlainText = view.findViewById(R.id.text_hash_generator_plain_text)
        textPlainText.setEndIconOnClickListener {
            textPlainText.editText?.text?.clear()
            textHashResult.text = ""
        }
        textHashResult = view.findViewById(R.id.text_hash_generator_hash_result)
        val buttonSubmit = view.findViewById<Button>(R.id.button_hash_generator_submit)
        buttonSubmit.setOnClickListener {
            val algorithm = HashAlgorithmFactory.create(textAlgorithm.text.toString())
            textHashResult.text = algorithm.hash(textPlainText.editText?.text.toString())
        }
        registerForContextMenu(textHashResult)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val activity = requireActivity()
        activity.menuInflater.inflate(R.menu.hash_result_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.menu_item_hash_result_copy) {
            ClipboardUtils.copy(
                context = requireContext(),
                label = "${textAlgorithm.text}: ${textPlainText.editText?.text}",
                content = textHashResult.text
            )
            true
        } else {
            super.onContextItemSelected(item)
        }
    }
}