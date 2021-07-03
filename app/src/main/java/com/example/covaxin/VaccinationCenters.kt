package com.example.covaxin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.covaxin.databinding.ActivityVaccinationCentersBinding
import org.json.JSONException

class VaccinationCenters : AppCompatActivity() {
    private lateinit var binding: ActivityVaccinationCentersBinding
    private lateinit var centerlist:MutableList<Centers>
    private lateinit var centeradapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccinationCentersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myrecyclerview.layoutManager = LinearLayoutManager(this)
        centerlist= mutableListOf()

        val pin = intent.getStringExtra("pin")
        val date = intent.getStringExtra("date")

        val url ="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=$pin&date=$date"

        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                val centerArray = response.getJSONArray("sessions")
                try{
                    if(centerArray.length()==0)
                    {
                        val intent = Intent(this,ErrorActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        for(i in 0 until centerArray.length())
                        {
                            val center = centerArray.getJSONObject(i)
                            val name:String =center.getString("name")
                            val address:String = center.getString("address")
                            val district:String =center.getString("district_name")
                            val fee_type:String =center.getString("fee_type")
                            val from:String =center.getString("from")
                            val to:String =center.getString("to")
                            val type_of_vaccine:String =center.getString("vaccine")
                            val mycenter = Centers(name,address,district,fee_type,from,to,type_of_vaccine)

                            centerlist.add(mycenter)

                        }
                    }
                 centeradapter = MyAdapter(centerlist)
                 binding.myrecyclerview.adapter = centeradapter
                 binding.myrecyclerview.setHasFixedSize(true)

                }
                catch (e: JSONException)
                {
                    e.printStackTrace()

                    Toast.makeText(this,"Please try again",Toast.LENGTH_LONG).show()
                }

            },
            { error ->

                Toast.makeText(this,"Failed to get response, try again",Toast.LENGTH_LONG).show()

            }
        )
        queue.add(jsonObjectRequest)

    }
}