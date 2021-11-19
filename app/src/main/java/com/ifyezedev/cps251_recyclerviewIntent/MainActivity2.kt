package com.ifyezedev.cps251_recyclerviewIntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifyezedev.cps251_recyclerviewIntent.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val title = extras.getString("title")
        val detail = extras.getString("detail")
        val image = extras.getInt("image")

        binding.textView.text = title
        binding.textView2.text = detail
        binding.imageView2.setImageResource(image)
    }

}