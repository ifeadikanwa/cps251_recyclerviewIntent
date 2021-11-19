package com.ifyezedev.cps251_recyclerviewIntent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(private val titles: List<String>,
                          private val details: List<String>,
                          private val images: List<Int>,
                          private val onItemClicked: (position: Int) -> Unit
): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)

        return ViewHolder(v, onItemClicked)
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View, private val onItemClicked: (position: Int) -> Unit)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemView.setOnClickListener(this)
            itemImage = itemView.findViewById(R.id.imageView)
            itemTitle = itemView.findViewById(R.id.chapterTextView)
            itemDetail = itemView.findViewById(R.id.detailsTextView)
        }

        override fun onClick(v: View?) {
           val position = adapterPosition
            onItemClicked(position)
        }
    }
}