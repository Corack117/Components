package com.example.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebView(view: View) {
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    fun openImagesView(view: View) {
        val intent = Intent(this, ImagesActivity::class.java)
        startActivity(intent)
    }

    fun openComponents(view: View) {
        val intent = Intent(this, ComponentsActivity::class.java)
        startActivity(intent)
    }

    fun openSearchComponent(view: View) {
        val intent = Intent(this, SearchViewActivity::class.java)
        startActivity(intent)
    }

    fun openExternalComponents(view: View) {
        val intent = Intent(this, ExternalComponentsActivity::class.java)
        startActivity(intent)
    }

    fun openGroupViews(view: View) {
        val intent = Intent(this, ListViewGroupsActivity::class.java)
        startActivity(intent)
    }
}