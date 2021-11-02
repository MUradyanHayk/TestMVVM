package com.example.testmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmvvm.manager.DataManager
import com.example.testmvvm.model.Car

class MainViewModel : ViewModel() {
    var cars: MutableLiveData<MutableList<Car>>? = null

    fun configure() {
        cars = MutableLiveData<MutableList<Car>>()
        cars?.value = DataManager.createCarDataSource()
    }
}