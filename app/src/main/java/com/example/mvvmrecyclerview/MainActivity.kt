package com.example.mvvmrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrecyclerview.adapters.CustomAdapter
import com.example.mvvmrecyclerview.viewModel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var customAdapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

             recyclerView = recycler_View

        var categoryViewModel: CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryViewModel.getArrayList().observe(this, Observer { categoryViewModel ->

            customAdapter = CustomAdapter(this@MainActivity, categoryViewModel)
            recyclerView.let {  it.layoutManager = LinearLayoutManager(this@MainActivity)}
            recyclerView.adapter = customAdapter
//            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//            recyclerView.adapter = customAdapter
        })
    }
}
