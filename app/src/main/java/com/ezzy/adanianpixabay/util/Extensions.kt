package com.ezzy.adanianpixabay.util

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ezzy.adanianpixabay.R
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat
import java.util.*

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.hideView() {
    visibility = View.GONE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

private val PUNCTUATION = listOf(", ", "; ", ": ", " ")
fun String.smartTruncate(length: Int): String {
    val words = split("")
    var added = 0
    var hasMore = false
    val builder = StringBuilder()

    for (word in words) {
        if (builder.length > length) {
            hasMore = true
            break
        }
        builder.append(word)
        builder.append("")
        added += 1
    }
    PUNCTUATION.map {
        if (builder.endsWith(it)) {
            builder.replace(builder.length - it.length, builder.length, "")
        }
    }
    if (hasMore) builder.append("...")
    return builder.toString()
}

@SuppressLint("SimpleDateFormat")
fun Long.formatTimeToDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("d MMM, yyyy HH:mm a", Locale.getDefault())
    return format.format(date)
}

@SuppressLint("SimpleDateFormat")
fun Long.formatTimeToSmallDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("d MMM, yyyy", Locale.getDefault())
    return format.format(date)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


fun ImageView.applyImage(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(
            ContextCompat.getDrawable(
                context, R.drawable.placeholder
            )
        )
        .into(this)
}

fun CircleImageView.applyImage(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(
            ContextCompat.getDrawable(
                context, R.drawable.placeholder
            )
        )
        .into(this)
}