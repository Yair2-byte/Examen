package com.example.aplicacion3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EmpleadoAdapter (private val context: Context, val listEmpleado: Empleado) : RecyclerView.Adapter<EmpleadoAdapter.ViewHolder>() {

    private var clickListener: ClickListener? = null

    interface ClickListener {
        fun onItemClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = listEmpleado[position]

        // sets the image to the imageview from our itemHolder class
        // sets the text to the textview from our itemHolder class
        holder.Idpassword.text = ItemsViewModel.password
        holder.IdIngreso.text = ItemsViewModel.login
    }

    override fun getItemCount(): Int {
        return listEmpleado.size
    }

    fun setOnItemClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        val IdIngreso: TextView = itemView.findViewById(R.id.login)
        val Idpassword: TextView = itemView.findViewById(R.id.password)

        init {
            if (clickListener != null){
                itemView.setOnClickListener(this)
            }
        }
        override fun onClick(itView: View){
            if(itView != null){
                clickListener?.onItemClick(itView, bindingAdapterPosition)
            }
        }
    }
}

