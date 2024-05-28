package com.example.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.components.databinding.ActivityListViewGroupsBinding

class ListViewGroupsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewGroupsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun openLinearLayout(view: View) {
        val intent = Intent(this, LinearLayoutActivity::class.java)
        startActivity(intent)
    }

    fun openRelativeLayout(view: View) {
        val intent = Intent(this, RelativeLayoutActivity::class.java)
        startActivity(intent)
    }

    fun openConstraintLayout(view: View) {
        val intent = Intent(this, ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }
}