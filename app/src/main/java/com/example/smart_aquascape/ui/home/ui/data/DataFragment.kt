package com.example.smart_aquascape.ui.home.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import com.example.smart_aquascape.databinding.FragmentDataBinding

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(DataViewModel::class.java)

        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textData
        dataViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}