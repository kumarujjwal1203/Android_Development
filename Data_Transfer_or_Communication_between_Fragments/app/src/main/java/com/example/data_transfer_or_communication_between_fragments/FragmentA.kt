package com.example.data_transfer_or_communication_between_fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    private var listener: FragmentAListener? = null

    interface FragmentAListener {
        fun onDataSend(input: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // MainActivity must implement FragmentAListener
        listener = context as? FragmentAListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val editText = view.findViewById<EditText>(R.id.etInput)
        val button = view.findViewById<Button>(R.id.btnSend)

        button.setOnClickListener {
            val input = editText.text.toString()
            listener?.onDataSend(input)
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
