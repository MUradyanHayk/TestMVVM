package com.example.testmvvm.model

import io.realm.RealmObject

open class Car : RealmObject() {
    var imgUrl: String = ""
    var name: String = ""
    var identifier: String = ""
}