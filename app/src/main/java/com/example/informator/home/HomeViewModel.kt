package com.example.informator.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.informator.network.CatAPIRepository
import com.example.informator.network.CatBreed
import com.example.informator.network.RandomCatResponse
import kotlinx.coroutines.launch

class HomeViewModel(
    private val catAPIRepository: CatAPIRepository
): ViewModel() {

    val randomCatData = MutableLiveData<RandomCatResponse>()
    val breedsData = MutableLiveData<List<CatBreed>>()

//    fun initialize() = viewModelScope.launch {
//        println("URL_KOTA: " + catAPIRepository.getRandomCatUrl())
//    }

    fun initialize() {
        viewModelScope.launch {
            val cat = catAPIRepository.getRandomCat()
            randomCatData.value = cat

            val breeds = catAPIRepository.getBreeds(5,10)
            breedsData.value = breeds

        }
    }
}