package com.example.helloworld

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val onClick: (Category, Int) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private val currentList = mutableListOf<Category>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Category>) {
        currentList.clear()
        currentList.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(
        itemView: View,
        onClick: (Category, Int) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {
        private val container =
            itemView.findViewById<com.google.android.material.card.MaterialCardView>(R.id.container)
        private val image = itemView.findViewById<ImageView>(R.id.img)
        private val text = itemView.findViewById<TextView>(R.id.txt)

        private var currentCategory: Category? = null
        private var currentPosition: Int? = null

        init {
            container.setOnClickListener {
                currentCategory?.let {
                    onClick(it, currentPosition ?: 0)
                }
            }
        }

        fun onBind(category: Category, position: Int) {
            currentCategory = category
            currentPosition = position
            image.setImageResource(category.imgRes)
            text.setText(category.titleRes)
        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_category, p0, false),
            onClick,
        )
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.onBind(currentList[p1], p1)
}