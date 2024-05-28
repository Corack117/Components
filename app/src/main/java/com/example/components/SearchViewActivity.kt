package com.example.components

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        val searchView: SearchView = findViewById(R.id.searchView)
        val listViews: ListView = findViewById(R.id.listView)
        val users = arrayOf("Alvaro", "Ana", " Amparo", "Carolina", "Sergio")
        val adapterUsers = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        listViews.adapter = adapterUsers
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                if (users.contains(query)) adapterUsers.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterUsers.filter.filter(newText)
                return false
            }
        })
    }
}