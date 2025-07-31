package com.example.data_transfer_or_communication_between_fragments


import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val textView = view.findViewById<TextView>(R.id.tvResult)

        // Get data from arguments
        val result = arguments?.getString("user_input")
        textView.text = "Received: $result"

        return view
    }
}
