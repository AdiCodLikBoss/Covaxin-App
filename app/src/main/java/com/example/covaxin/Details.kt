package com.example.covaxin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.covaxin.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.search.setOnClickListener{

            val mypin:String  = binding.pin.text.toString()
            val mydate:String = binding.date.text.toString()
            val intent = Intent(this,VaccinationCenters::class.java)
            intent.putExtra("pin",mypin)
            intent.putExtra("date",mydate)
            if(mypin.length==6 && mydate.length==10)
            {
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Please enter the details in correct format",Toast.LENGTH_SHORT).show()
            }
        }


    }
}