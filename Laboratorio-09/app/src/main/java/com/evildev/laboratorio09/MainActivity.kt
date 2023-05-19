package com.evildev.laboratorio09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evildev.CoroutinesDemo.R
import com.evildev.CoroutinesDemo.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}