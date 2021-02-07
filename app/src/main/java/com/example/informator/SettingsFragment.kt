package com.example.informator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.zip.Inflater

class SettingsFragment : Fragment () {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container ,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.passwordChangeButton).setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_changePasswordFragment)
        }


        view.findViewById<Button>(R.id.firstNameChangeButton).setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_changeNameFragment)
        }

        view.findViewById<Button>(R.id.lastNameCheangeButton).setOnClickListener{
            findNavController().navigate(R.id.action_settingsFragment_to_changeNameFragment)
        }
    }



}