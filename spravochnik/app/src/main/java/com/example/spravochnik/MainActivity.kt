package com.example.spravochnik

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import com.example.spravochnik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val COUNT = "COUNT"
    }
    private  lateinit var  binding: ActivityMainBinding
    private  lateinit var  listAdapter:ListAdapter
    private  lateinit var  listData:ListData
    var dataArrayList = ArrayList<ListData?>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView6.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.drawable.anim_show))
        val nameList = arrayOf("Создание RDS","Команды","Автомобили")

        val imageList = arrayOf(
            R.drawable.istory,
            R.drawable.komanda,
            R.drawable.avtomobili,)
        for (i in imageList.indices){
            listData = ListData(nameList[i],imageList[i])
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity,dataArrayList)
        binding.listView.adapter=listAdapter
        binding.listView.isClickable = true

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{adapterView, view, i,l ->
            val intent =Intent(this@MainActivity, DetailedActivity::class.java)

            intent.putExtra(COUNT, i)
            startActivity(intent)
        }
    }
}