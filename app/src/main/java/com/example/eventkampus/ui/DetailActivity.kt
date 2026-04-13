package com.example.eventkampus.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventkampus.R
import com.example.eventkampus.data.EventRepository
import com.example.eventkampus.model.Event

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("EVENT_ID", -1)
        val event: Event? = EventRepository.getEventById(id)
        val nama = findViewById<TextView>(R.id.txtNamaDetail)
        val deskripsi = findViewById<TextView>(R.id.txtDeskripsi)
        val img = findViewById<ImageView>(R.id.imgDetail)
        val btn = findViewById<Button>(R.id.btnDaftar)

        event?.let {
            nama.text = it.namaEvent
            deskripsi.text = it.deskripsi
            img.setImageResource(it.imageResId)
        } ?: run {
            Toast.makeText(this, "Event tidak ditemukan!", Toast.LENGTH_SHORT).show()
        }

        btn.setOnClickListener {
            Toast.makeText(this, "Berhasil daftar event!", Toast.LENGTH_SHORT).show()
        }
    }
}
