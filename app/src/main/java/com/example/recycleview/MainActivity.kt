package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StudentAdapter.onItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val studList = listOf(
        Student("W0001", "Alex", "RSF", "F"),
        Student("W0002", "King", "RSF", "F"),
        Student("W0003", "Ben", "RST", "M"),
        Student("W0004", "Kai", "RSF", "M"),
        Student("W0005", "Stephen", "RIT", "M"),
        Student("W0006", "Morgan", "RIT", "M"),
        Student("W0007", "Wenhan", "RSF", "M")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = StudentAdapter(studList, this)
        binding.recycleViewStud.adapter = adapter
        binding.recycleViewStud.layoutManager = LinearLayoutManager(applicationContext)
        binding.recycleViewStud.setHasFixedSize(true)

    }

    override fun itemClick(position: Int) {
        val selectedStud = studList[position]
        Toast.makeText(applicationContext, selectedStud.name, Toast.LENGTH_SHORT).show()
    }
}