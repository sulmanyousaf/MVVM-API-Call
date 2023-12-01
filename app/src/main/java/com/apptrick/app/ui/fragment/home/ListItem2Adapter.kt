package com.apptrick.app.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.apptrick.app.data.api.model.responsemodels.ProductResponse
import com.apptrick.app.databinding.ListItem2Binding

class ListItem2Adapter(private val productsList: List<ProductResponse.Products>) :
    RecyclerView.Adapter<ListItem2Adapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = ListItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    class ImageViewHolder(private val binding: ListItem2Binding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductResponse.Products) {
            binding.apply {
                ivItem.load(item.thumbnail)
                tvTitle.text = item.title.orEmpty()
                tvPrice.text = item.price.toString()
            }
        }
    }
}