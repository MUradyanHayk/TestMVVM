package com.example.testmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val addButton = findViewById<Button>(R.id.add_btn_id)
        val editText = findViewById<EditText>(R.id.edit_text_id)

        viewModel?.configure(this)

        createRecyclerView()

        addButton?.setOnClickListener {
            viewModel?.addItem(editText?.text?.toString()?.trim() ?: "")
        }

    }

    private fun createRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_id)
        adapter = CarAdapter(this, WeakReference(this), viewModel?.realmDB?.where(Car::class.java)?.findAll())
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
//        viewModel?.cars?.observe(this) {
//            adapter?.notifyDataSetChanged()
//        }
    }

    override fun onItemClick(identifier: String) {
        viewModel?.changeName(identifier, "click")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.realmDB?.close()
    }
}