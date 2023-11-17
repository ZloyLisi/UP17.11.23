package com.example.spravochnik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.spravochnik.databinding.ActivityDetailedBinding
import com.example.spravochnik.databinding.ActivityMainBinding

class DetailedActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        val argument:Bundle? = intent.extras

        val firstFragment = RazvitieFragment()
        val komandsFragment = KomandsFragment()
        val avtomobiliFragment = AvtomobiliFragment()


        if (argument != null){
           count = argument.getInt(MainActivity.COUNT)
        }

        when(count){
            0 -> {
                launchFragment(firstFragment)
            }
            1 -> {
                launchFragment(komandsFragment)
            }
            2 -> {
                launchFragment(avtomobiliFragment)
            }

        }

    }
    val fragmentManager = supportFragmentManager

    fun launchFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}