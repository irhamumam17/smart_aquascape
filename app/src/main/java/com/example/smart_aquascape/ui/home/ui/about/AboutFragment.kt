package com.example.smart_aquascape.ui.home.ui.about

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smart_aquascape.databinding.FragmentAboutBinding
import com.example.smart_aquascape.ui.login.LoginActivity

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private lateinit var sharedPreferences: SharedPreferences

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
                AboutViewModel::class.java
            )

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        sharedPreferences = activity!!.getSharedPreferences("PREFERENCES_NAME", Context.MODE_PRIVATE)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        aboutViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        _binding!!.btnLogout.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.remove("SESSION_ID")
            editor.commit()
            activity?.let {
                val intent = Intent(it, LoginActivity::class.java)
                it.startActivity(intent)
                it.finish()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}