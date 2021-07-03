package com.example.covaxin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(val centerlist: List<Centers>):RecyclerView.Adapter<MyAdapter.myviewholder>() {
    inner class myviewholder(item: View):RecyclerView.ViewHolder(item)
    {
        val name_of_center = item.findViewById<TextView>(R.id.name)
        val address =item.findViewById<TextView>(R.id.address)
        val district=item.findViewById<TextView>(R.id.district)
        val fee_type=item.findViewById<TextView>(R.id.fee_type)
        val from=item.findViewById<TextView>(R.id.from)
        val to=item.findViewById<TextView>(R.id.to)
        val type_of_vaccine=item.findViewById<TextView>(R.id.vaccine_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.center_style,parent,false)
        return myviewholder(itemview)

    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        val mycenter:Centers
        mycenter=centerlist[position]
        holder.name_of_center.text=mycenter.name.toUpperCase()
        holder.address.text=mycenter.address.toUpperCase()
        holder.district.text=mycenter.district.toUpperCase()
        holder.fee_type.text=mycenter.fee_type.toUpperCase()
        holder.from.text=mycenter.from.substring(0,5)
        holder.to.text=mycenter.to.substring(0,5)
        holder.type_of_vaccine.text=mycenter.type_of_vaccine.toUpperCase()
    }

    override fun getItemCount(): Int {
       return centerlist.size
    }
}