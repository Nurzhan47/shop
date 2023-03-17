package com.example.helloworld

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TVAdapter(private val onClick: (TV, Int) -> Unit) :
    RecyclerView.Adapter<TVAdapter.ViewHolder>() {
    private val currentList1 = mutableListOf<TV>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateListTV(newTVList: List<TV>) {
        currentList1.clear()
        currentList1.addAll(newTVList)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addToListTV(TV: TV) {
        currentList1.add(TV)
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemView: View, onClick: (TV, Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val imgCategory1: ImageView
        private val txtCategory1: TextView
        private val txtTv1: TextView
        private val txtTV2: TextView
        private var currentCategory1: TV? = null
        private var currentPosition1: Int? = null


        init {
            println("ViewHolder Initialized")
            imgCategory1 = itemView.findViewById(R.id.flag)
            txtCategory1 = itemView.findViewById(R.id.name)
            txtTv1 = itemView.findViewById(R.id.subtitle)
            txtTV2 = itemView.findViewById(R.id.price)

            itemView.findViewById<LinearLayout>(R.id.container).setOnClickListener {
                currentCategory1?.let {
                    onClick(it, currentPosition1 ?: 0)
                }

            }
        }

        fun onBind(TV: TV, position: Int) {
            currentCategory1 = TV
            currentPosition1 = position
            Picasso.with(itemView.context).load(TV.imgRes).into(imgCategory1)
            txtCategory1.setText(TV.titleRes)
            txtTv1.setText(TV.rating.toString())
            txtTV2.setText(TV.price)

        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.listoftv, p0, false),
            onClick,
        )
    }

    override fun getItemCount() = currentList1.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.onBind(currentList1[p1], p1)
}