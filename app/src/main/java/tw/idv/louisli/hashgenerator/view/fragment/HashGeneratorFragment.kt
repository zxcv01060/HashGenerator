package tw.idv.louisli.hashgenerator.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import tw.idv.louisli.hashgenerator.R
import tw.idv.louisli.hashgenerator.algorithm.HashAlgorithmFactory
import tw.idv.louisli.hashgenerator.util.ClipboardUtils

class HashGeneratorFragment(private val sharedPlainText: String? = null) : Fragment() {
    private lateinit var textAlgorithm: AutoCompleteTextView
    private lateinit var textPlainText: TextInputLayout
    private lateinit var textSalt: TextInputLayout
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
        textPlainText.editText?.setText(sharedPlainText)
        textPlainText.setEndIconOnClickListener {
            textPlainText.editText?.text?.clear()
            textHashResult.text = ""
        }

        textSalt = view.findViewById(R.id.text_hash_generator_salt)

        textHashResult = view.findViewById(R.id.text_hash_generator_hash_result)
        registerForContextMenu(textHashResult)

        view.findViewById<View>(R.id.button_hash_generator_submit)
            .setOnClickListener {
                val algorithm = HashAlgorithmFactory.create(textAlgorithm.text.toString())
                textHashResult.text = algorithm.hash(
                    textPlainText.editText?.text.toString(),
                    textSalt.editText?.text.toString()
                )
            }
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
        return when (item.itemId) {
            R.id.menu_item_hash_result_copy -> {
                copyHashResultToClipboard()
                true
            }
            R.id.menu_item_hash_result_share -> {
                shareHashResultToOtherApp()
                true
            }
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

    private fun copyHashResultToClipboard() {
        ClipboardUtils.copy(
            context = requireContext(),
            label = "${textAlgorithm.text}: " +
                    "${textPlainText.editText?.text}(Salt: ${textSalt.editText?.text})",
            content = textHashResult.text
        )
    }

    private fun shareHashResultToOtherApp() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textHashResult.text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}