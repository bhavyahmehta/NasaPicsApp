package com.example.nasapicsappsample.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<DATA_MODEL>(diffCallback: DiffUtil.ItemCallback<DATA_MODEL>)
    : ListAdapter<DATA_MODEL, BaseViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getItemLayoutId(viewType),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        onBind(holder)?.executePendingBindings()
    }

    fun getCurrentItem(holder: BaseViewHolder) = getItem(holder.adapterPosition)

    fun getItemAt(position: Int) = getItem(position)

    abstract fun getItemLayoutId(viewType: Int): Int

    abstract fun onBind(holder: BaseViewHolder): ViewDataBinding?

}