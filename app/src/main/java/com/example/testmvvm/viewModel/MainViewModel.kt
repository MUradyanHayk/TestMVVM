package com.example.testmvvm.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testmvvm.model.Car
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import java.util.*
import kotlin.random.Random

class MainViewModel : ViewModel() {
    var realmDB: Realm? = null

    fun configure(context: Context) {
        Realm.init(context)
        realmDB = Realm.getDefaultInstance()

//        cars?.value = DataManager.createCarDataSource()
    }

    fun addItem(name: String) {
        realmDB?.beginTransaction()
//        cars?.value?.add(item)
        val car = realmDB?.createObject(Car::class.java)
        val identifier = System.currentTimeMillis().toString() + UUID.randomUUID() + car?.hashCode()?.toString()
        car?.name = name
        car?.identifier = identifier
        realmDB?.commitTransaction()
    }

    fun changeName(identifier: String, name: String) {
//        cars?.value?.get(position)?.name = name
        realmDB?.beginTransaction()
        val car = realmDB?.where(Car::class.java)?.equalTo("identifier", identifier)?.findFirst()
        car?.name = name
        realmDB?.commitTransaction()
    }
}