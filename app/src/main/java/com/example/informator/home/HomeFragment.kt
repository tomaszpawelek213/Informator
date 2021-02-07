package com.example.informator.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.informator.R
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment () {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel) {
            randomCatData.observe(viewLifecycleOwner) {
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                Picasso.get().load(it.url).into(imageView);

                view.findViewById<TextView>(R.id.widthPhotoTextView).text = "szerkokosć: ${it.width}"
                view.findViewById<TextView>(R.id.heightPhotoTextView).text ="wyskość: ${it.height}"
                view.findViewById<TextView>(R.id.idCatTextView).text ="id: ${it.id}"

                if (it.breeds.isNotEmpty()) {
                    view.findViewById<TextView>(R.id.catBreedTextView).text ="rasa: ${it.breeds[0].name}"
                    view.findViewById<TextView>(R.id.catImperialTextView).text ="waga : ${it.breeds[0].weight.imperial}"

                } else {
                    view.findViewById<TextView>(R.id.catBreedTextView).text ="rasa: BRAK"
                    view.findViewById<TextView>(R.id.catImperialTextView).text ="waga: BRAK"
                }
            }
            breedsData.observe(viewLifecycleOwner) { list ->
                var breedsString = "Rasy: "
                list.map { catBreed -> catBreed.name }.forEach {
                    breedsString += "$it, "
                }
                view.findViewById<TextView>(R.id.catBreedsTextView).text = breedsString
            }

            view.findViewById<Button>(R.id.settingsButton).setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
            }
            view.findViewById<ImageView>(R.id.imageView).setOnClickListener {
                initialize()
            }
            initialize()
        }


    }


}