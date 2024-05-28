package com.example.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.components.databinding.ActivityExternalComponentsBinding
import com.example.components.databinding.ActivityMainBinding

class ExternalComponentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExternalComponentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExternalComponentsBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_external_components)
        setContentView(binding.root)

        binding.textView.text = "External Components"
    }
}