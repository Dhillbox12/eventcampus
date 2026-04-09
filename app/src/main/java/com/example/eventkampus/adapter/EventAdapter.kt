package com.example.eventkampus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.eventkampus.R
import com.example.eventkampus.model.Event

class EventAdapter(
    private val context: Context,
    private val list: List<Event>
) : BaseAdapter() {

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)
            holder = ViewHolder()
            holder.nama = view.findViewById(R.id.txtNama)
            holder.tanggal = view.findViewById(R.id.txtTanggal)
            holder.lokasi = view.findViewById(R.id.txtLokasi)
            holder.img = view.findViewById(R.id.imgEvent)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val event = list[position]

        holder.nama?.text = event.namaEvent
        holder.tanggal?.text = event.tanggal
        holder.lokasi?.text = event.lokasi
        holder.img?.setImageResource(event.imageResId)

        return view
    }

    private class ViewHolder {
        var nama: TextView? = null
        var tanggal: TextView? = null
        var lokasi: TextView? = null
        var img: ImageView? = null
    }
}