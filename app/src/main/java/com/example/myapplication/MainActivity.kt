package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Root
import com.example.myapplication.repository.Repository
//hello
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding:ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = linearLayoutManager

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAmiibo()
        viewModel.myResponse.observe(this, { response->
            if(response.isSuccessful){
                val root: Root? = response.body()
                if (root != null) {
                    Log.d("Response",root.amiibo.toString())
                    val adapter = CustomAdapter(root.amiibo)
                    binding.recycler.adapter = adapter
                }
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })
    }
}