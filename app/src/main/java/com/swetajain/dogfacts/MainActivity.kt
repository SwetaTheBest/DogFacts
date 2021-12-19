package com.swetajain.dogfacts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.dogfacts.adapters.FactsAdapter
import com.swetajain.dogfacts.databinding.ActivityMainBinding
import com.swetajain.dogfacts.viewmodel.FactsViewModel
import com.swetajain.dogfacts.viewmodel.FactsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var factsViewModel: FactsViewModel
    private lateinit var recyclerView: RecyclerView
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MyTheme)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = (application as FactsApplication).factsRepository

        factsViewModel = ViewModelProvider(
            this,
            FactsViewModelFactory(repository)
        )[FactsViewModel::class.java]

        val adapter = FactsAdapter()
        recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        factsViewModel.getAllDatabaseFacts()
        factsViewModel.factsList.observe(this, { list ->
            adapter.setData(list)
            list.map {
                Log.d("F", it.fact)
            }
        })
        binding.fabAdd.setOnClickListener {
            factsViewModel.getTenFacts()

            factsViewModel.factsList.observe(this, { list ->
                adapter.setData(list)
                list.map {
                    Log.d("F", it.fact)
                }
            })

        }
    }
}