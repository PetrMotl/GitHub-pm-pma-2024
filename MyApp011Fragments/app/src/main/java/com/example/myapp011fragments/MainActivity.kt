package com.example.myapp011fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myapp011fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment1.setOnClickListener{
            replaceFragment(Fragment1())
        }
        binding.btnFragment2.setOnClickListener{
            replaceFragment(Fragment2())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        //získá instancí správce fragmentu
        val fragmentManager = supportFragmentManager

        //vytvoří transakci  s fragmenty
        val fragmentTransaction = fragmentManager.beginTransaction()

        //nahradí fragmnet v konteineru a nahradí ho novým
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)

        //potvrdí transakci  a provede výměnu fragmentu
        fragmentTransaction.commit()
    }
}