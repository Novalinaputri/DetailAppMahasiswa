package com.novalina.crud_mahasiswa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.novalina.crud_mahasiswa.R
import com.novalina.crud_mahasiswa.model.ModelMahasiswa

class MahasiswaAdapter(
    private var listMahasiswa: List<ModelMahasiswa>,
    context:Context
) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    class MahasiswaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val txtNama : TextView = itemView.findViewById(R.id.txtItemNamaMahasiswa)
        val txtJurusan : TextView = itemView.findViewById(R.id.txtItemJurusan)
        val txtNim : TextView = itemView.findViewById(R.id.txtItemNIM)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaAdapter.MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_mahasiswa,parent, false
        )
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }
    override fun onBindViewHolder(holder: MahasiswaAdapter.MahasiswaViewHolder, position: Int) {
        val nMahasiswa = listMahasiswa[position]
        holder.txtNim.text = nMahasiswa.nim.toString()
        holder.txtNama.text = nMahasiswa.nama
        holder.txtJurusan.text = nMahasiswa.jurusan
    }
    //ini untuk refresh data
    fun refreshData(newMahasiswa: List<ModelMahasiswa>){
        listMahasiswa = newMahasiswa
        notifyDataSetChanged()
    }
}