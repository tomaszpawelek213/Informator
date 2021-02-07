package com.example.informator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ChangePasswordFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialButton>(R.id.changePasswordButton).setOnClickListener {
            val previousPassword = view.findViewById<TextInputEditText>(R.id.lastPassword).text.toString()
            val newPassword = view.findViewById<TextInputEditText>(R.id.newPassword).text.toString()
            val repeatNewPassword = view.findViewById<TextInputEditText>(R.id.repeatNewPassword).text.toString()

            if (previousPassword.isEmpty() || newPassword.isEmpty() || repeatNewPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Uzupelnij dane", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (previousPassword != "admin") {
                Toast.makeText(requireContext(), "Zle stare haslo", Toast.LENGTH_SHORT).show()
            }

            if (newPassword == repeatNewPassword) {
                Toast.makeText(requireContext(), "Zapisano nowe haslo", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "nowe hasla sa rozne", Toast.LENGTH_SHORT).show()

            }

        }
    }
}