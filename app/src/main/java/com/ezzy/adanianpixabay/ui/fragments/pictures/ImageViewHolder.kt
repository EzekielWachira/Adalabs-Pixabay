package com.ezzy.adanianpixabay.ui.fragments.pictures

import androidx.recyclerview.widget.RecyclerView
import com.ezzy.adanianpixabay.databinding.ImageItemBinding
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.util.applyImage

class ImageViewHolder(
    private val binding: ImageItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bindItem(imageItem: Image) {
        with(binding) {
            userName.text = imageItem.user
            image.applyImage(imageItem.previewURL)
            downloads.text = "${imageItem.downloads} downloads"
            likes.text = imageItem.likes.toString()
            comments.text = imageItem.comments.toString()
            views.text = imageItem.views.toString()
        }
    }
}