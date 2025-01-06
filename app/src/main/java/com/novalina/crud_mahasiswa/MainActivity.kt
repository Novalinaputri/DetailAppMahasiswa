package com.novalina.crud_mahasiswa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.novalina.crud_mahasiswa.adapter.MahasiswaAdapter
import com.novalina.crud_mahasiswa.databinding.ActivityMainBinding
import com.novalina.crud_mahasiswa.helper.DbHelper
import com.novalina.crud_mahasiswa.screen_page.TambahDataMahasiswaActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db : DbHelper
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this, null)
        mahasiswaAdapter = MahasiswaAdapter(db.getAllDataMahasiswa(),this)

        binding.rvDataMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvDataMahasiswa.adapter = mahasiswaAdapter

        binding.btnPageTambah.setOnClickListener{
            val intent = Intent(this,TambahDataMahasiswaActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onResume() {
        super.onResume()
        val newMahasiswa = db.getAllDataMahasiswa()
        mahasiswaAdapter.refreshData(newMahasiswa)
    }
}