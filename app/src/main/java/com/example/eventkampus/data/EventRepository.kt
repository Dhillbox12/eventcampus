package com.example.eventkampus.data

// 1. TAMBAHKAN IMPORT INI agar EventRepository mengenali class Event
import com.example.eventkampus.model.Event
// 2. PASTIKAN IMPORT R INI SESUAI (Cek nama package utama di AndroidManifest.xml)
import com.example.eventkampus.R

object EventRepository {

    private val events = listOf(
        // Perhatikan: Nama parameter di Event.kt kamu adalah 'imageResId'
        // Kode di bawah sudah disesuaikan urutannya dengan data class Event kamu
        Event(
            id = 1,
            namaEvent = "Seminar AI",
            penyelenggara = "Informatika",
            tanggal = "10 Mei",
            lokasi = "ruang 203-204",
            deskripsi = "Belajar AI",
            imageResId = R.drawable.ic_launcher_foreground,
            kategori = "Seminar"
        ),
        Event(
            id = 2,
            namaEvent = "Lomba Coding",
            penyelenggara = "Himpunan",
            tanggal = "15 Mei",
            lokasi = "Lab",
            deskripsi = "Kompetisi coding",
            imageResId = R.drawable.ic_launcher_foreground,
            kategori = "Lomba"
        ),
        Event(
            id = 3,
            namaEvent = "Workshop UI",
            penyelenggara = "Desain",
            tanggal = "20 Mei",
            lokasi = "Ruang 203",
            deskripsi = "Belajar UI",
            imageResId = R.drawable.ic_launcher_foreground,
            kategori = "Workshop"
        ),
        Event(
            id = 4,
            namaEvent = "Seminar Startup",
            penyelenggara = "Bisnis",
            tanggal = "25 Mei",
            lokasi = "ruang 203-204l",
            deskripsi = "Startup talk",
            imageResId = R.drawable.ic_launcher_foreground,
            kategori = "Seminar"
        )
    )

    fun getEvents(): List<Event> = events

    fun getEventById(id: Int): Event? {
        return events.find { it.id == id }
    }
}