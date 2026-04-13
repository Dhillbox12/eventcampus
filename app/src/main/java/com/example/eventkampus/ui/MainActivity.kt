package com.example.eventkampus.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.eventkampus.R
import com.example.eventkampus.adapter.EventAdapter
import com.example.eventkampus.data.EventRepository 

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewEvents)

        val events = EventRepository.getEvents()

        val adapter = EventAdapter(this, events)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedEvent = events[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("EVENT_ID", selectedEvent.id)
            startActivity(intent)
        }
    }
}
