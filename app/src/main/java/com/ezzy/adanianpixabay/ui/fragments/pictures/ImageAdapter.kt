package com.ezzy.adanianpixabay.ui.fragments.pictures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ezzy.adanianpixabay.databinding.ImageItemBinding
import com.ezzy.adanianpixabay.domain.model.Image

class ImageAdapter : ListAdapter<Image, ImageViewHolder>(UploadImageCallback) {

    private var onItemClickListener: ((Image?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.apply {
            bindItem(getItem(position))
            baseLayout.setOnClickListener {
                onItemClickListener?.let {
                    it(getItem(position))
                }
            }
        }
    }

    private object UploadImageCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnClickListener(listener: (Image?) -> Unit) {
        onItemClickListener = listener
    }

}

