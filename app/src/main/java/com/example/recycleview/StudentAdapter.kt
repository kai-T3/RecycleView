package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val list: List<Student>, private val listener: onItemClickListener): RecyclerView.Adapter<StudentAdapter.myViewHolder>() {

    inner class myViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvID: TextView = itemView.findViewById(R.id.tvID)
        val tvName: TextView = itemView.findViewById(R.id.tvStudentName)
        val tvProg: TextView = itemView.findViewById(R.id.tvProg)
        val picPhoto: ImageView = itemView.findViewById(R.id.personPhoto)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }
        }
    }

    interface onItemClickListener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentStudent = list[position]
        holder.tvID.text = currentStudent.id
        holder.tvName.text = currentStudent.name
        holder.tvProg.text = currentStudent.programme

        if(currentStudent.gender == "F"){
            holder.picPhoto.setImageResource(R.drawable.ic_female)
        }else holder.picPhoto.setImageResource(R.drawable.ic_male)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}