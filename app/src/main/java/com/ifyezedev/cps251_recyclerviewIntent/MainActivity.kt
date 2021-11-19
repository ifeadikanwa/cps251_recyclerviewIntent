package com.ifyezedev.cps251_recyclerviewIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifyezedev.cps251_recyclerviewIntent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerviewAdapter(viewModel.randomTitles, viewModel.randomDetails, viewModel.randomImages){position -> onListItemClick(position)}
        binding.recyclerView.adapter = adapter

    }

    private fun onListItemClick(position: Int) {
        val intent = Intent(this, MainActivity2::class.java)

        val title = viewModel.randomTitles[position]
        val detail = viewModel.randomDetails[position]
        val image = viewModel.randomImages[position]

        intent.putExtra("title", title)
        intent.putExtra("detail", detail)
        intent.putExtra("image", image)

        startActivity(intent)
    }
}