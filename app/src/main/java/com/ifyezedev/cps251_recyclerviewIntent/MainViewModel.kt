package com.ifyezedev.cps251_recyclerviewIntent

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val randomTitles = mutableListOf<String>()
    val randomDetails = mutableListOf<String>()
    val randomImages = mutableListOf<Int>()

    init {
        setRandomTitles()
        setRandomDetails()
        setRandomImages()
    }

    private fun setRandomTitles() {
        repeat(Data.titles.size) {
            randomTitles.add(Data.titles.random())
        }
    }

    private fun setRandomDetails() {
        repeat(Data.titles.size) {
            randomDetails.add(Data.details.random())
        }
    }

    private fun setRandomImages() {
        repeat(Data.titles.size) {
            randomImages.add(Data.images.random())
        }
    }
}