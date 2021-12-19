package com.swetajain.dogfacts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.swetajain.dogfacts.databinding.ActivityMainBinding
import com.swetajain.dogfacts.viewmodel.FactsViewModel
import com.swetajain.dogfacts.viewmodel.FactsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var factsViewModel: FactsViewModel

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

        factsViewModel.fact.observe(this, { list ->
            list.map {
                Log.d("F", it.fact)
            }
        })
    }
}