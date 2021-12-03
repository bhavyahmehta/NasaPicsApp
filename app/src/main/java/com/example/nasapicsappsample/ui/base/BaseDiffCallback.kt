package com.example.nasapicsappsample.ui.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffCallback<DATA_MODEL> : DiffUtil.ItemCallback<DATA_MODEL>() {

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DATA_MODEL, newItem: DATA_MODEL) =
        oldItem == newItem

}
