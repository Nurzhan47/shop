package com.example.helloworld

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class TVAdapter(
    private val onItemClick: (Element) -> Unit,
    private val onAddClick: (Element) -> Unit,
) : RecyclerView.Adapter<TVAdapter.ViewHolder>() {
    private val currentList = mutableListOf<Element>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newElementList: List<Element>) {
        currentList.clear()
        currentList.addAll(newElementList)
        notifyDataSetChanged()
    }

    class ViewHolder(
        itemView: View,
        onItemClick: (Element) -> Unit,
        onAddClick: (Element) -> Unit,
    ) : RecyclerView.ViewHolder(itemView) {
        private val container =
            itemView.findViewById<com.google.android.material.card.MaterialCardView>(R.id.container)
        private val image = itemView.findViewById<ImageView>(R.id.img)
        private val txtTitle = itemView.findViewById<TextView>(R.id.txt_title)
        private val txtSubtitle = itemView.findViewById<TextView>(R.id.txt_subtitle)
        private val txtPrice = itemView.findViewById<TextView>(R.id.txt_price)
        private val btnAdd = itemView.findViewById<ImageView>(R.id.btn_add)

        private var currentCategory: Element? = null

        init {
            container.setOnClickListener { currentCategory?.let(onItemClick) }
            btnAdd.setOnClickListener { currentCategory?.let(onAddClick) }
        }

        fun onBind(element: Element) {
            currentCategory = element

            image.load(element.imageUrl) {
                crossfade(true)
            }
            txtTitle.text = element.title
            txtSubtitle.text =
                "Телевизор Neo QLED выходит на новую ступень с технологией Quantum Matrix, которая управляет нашими новыми эксклюзивными светодиодами Quantum Mini. Благодаря точному управлению светом вы можете наслаждаться мельчайшими деталями как в самых темных, так и в самых ярких сценах."
            txtPrice.text = element.price
        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_element, p0, false),
            onItemClick,
            onAddClick
        )
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(vh: ViewHolder, pos: Int) = vh.onBind(currentList[pos])
}