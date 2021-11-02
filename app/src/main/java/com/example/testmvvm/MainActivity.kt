package com.example.testmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testmvvm.adapter.CarAdapter
import com.example.testmvvm.adapter.CarAdapterDelegate
import com.example.testmvvm.model.Car
import com.example.testmvvm.viewModel.MainViewModel
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), CarAdapterDelegate {
    private var viewModel: MainViewModel? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: CarAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel?.configure()

        createRecyclerView()
    }

    private fun createRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_id)
        adapter = CarAdapter(this, WeakReference(this), viewModel?.cars?.value!!)
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
//        viewModel?.cars?.observe{}
    }

    override fun onItemClick(car: Car) {
        viewModel?.cars?.observe(this) {
            car.name = "click"
            adapter?.notifyDataSetChanged()
        }
    }
}