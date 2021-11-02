package com.example.testmvvm.manager

import com.example.testmvvm.model.Car

object DataManager {
    var carList = mutableListOf<Car>()

    fun createCarDataSource(): MutableList<Car> {
        val list = mutableListOf<Car>()
        var data = Car("https://images.ctfassets.net/23aumh6u8s0i/4JKsesGb6RuQLsjVnUmB0j/0bcbb36344547e9ab698b9077f80170a/16_brightness", "name 1")
        list.add(data)

        data = Car("https://www.pixsy.com/wp-content/uploads/2021/04/ben-sweet-2LowviVHZ-E-unsplash-1.jpeg", "name 2")
        list.add(data)

        data = Car("https://ix-www.imgix.net/hp/snowshoe.jpg?q=70&w=1800&auto=compress%2Cenhance&fm=jpeg", "name 3")
        list.add(data)

        data = Car("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/6057684e5923ad2ae43c8150_bavassano_homepage_before.jpg", "name 4")
        list.add(data)

        data = Car("https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg", "name 5")
        list.add(data)

        data = Car("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFU7U2h0umyF0P6E_yhTX45sGgPEQAbGaJ4g&usqp=CAU", "name 6")
        list.add(data)

        data = Car("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlrZqTCInyg6RfYC7Ape20o-EWP1EN_A8fOA&usqp=CAU", "name 7")
        list.add(data)

        data = Car("https://image.shutterstock.com/image-photo/surreal-image-african-elephant-wearing-260nw-1365289022.jpg", "name 8")
        list.add(data)

        data = Car("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQllPMPJIAkDNlRvUPQ02aVsbn5KK1q1qHZaw&usqp=CAU", "name 9")
        list.add(data)

        data = Car("https://cdn.searchenginejournal.com/wp-content/uploads/2019/08/c573bf41-6a7c-4927-845c-4ca0260aad6b-760x400.jpeg", "name 10")
        list.add(data)

        carList.clear()
        carList.addAll(list)
        return list
    }
}