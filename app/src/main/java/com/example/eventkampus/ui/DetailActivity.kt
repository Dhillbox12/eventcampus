package com.example.eventkampus.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventkampus.R
import com.example.eventkampus.data.EventRepository
// PENTING: Kamu wajib mengimport class Event karena letaknya di package yang berbeda (.model)
import com.example.eventkampus.model.Event

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 1. Ambil ID dari Intent
        val id = intent.getIntExtra("EVENT_ID", -1)

        // 2. Ambil data dari Repository
        // Kita beri tipe data eksplisit : Event? supaya aman
        val event: Event? = EventRepository.getEventById(id)

        // 3. Inisialisasi View (Pastikan ID ini ada di activity_detail.xml)
        val nama = findViewById<TextView>(R.id.txtNamaDetail)
        val deskripsi = findViewById<TextView>(R.id.txtDeskripsi)
        val img = findViewById<ImageView>(R.id.imgDetail)
        val btn = findViewById<Button>(R.id.btnDaftar)

        // 4. Masukkan data ke dalam View
        event?.let {
            nama.text = it.namaEvent
            deskripsi.text = it.deskripsi
            img.setImageResource(it.imageResId)
        } ?: run {
            // Jika data event null/tidak ditemukan
            Toast.makeText(this, "Event tidak ditemukan!", Toast.LENGTH_SHORT).show()
        }

        // 5. Logika tombol daftar
        btn.setOnClickListener {
            Toast.makeText(this, "Berhasil daftar event!", Toast.LENGTH_SHORT).show()
        }
    }
}