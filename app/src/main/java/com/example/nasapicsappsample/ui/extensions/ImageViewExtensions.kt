package com.example.nasapicsappsample.ui.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    this.let {
        Glide.with(this.context)
            .load(url ?: "")
            .transition(withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(it)

    }
}


