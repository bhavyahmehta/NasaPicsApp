package com.example.nasapicsappsample.ui.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(viewBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    init {
        DataBindingUtil.bind<ViewDataBinding>(itemView)
    }

    fun <T : ViewDataBinding> getBinding(clazz: Class<T>) =
            DataBindingUtil.getBinding<T?>(this.itemView)

    val viewDataBinding get() = DataBindingUtil.getBinding<ViewDataBinding?>(this.itemView)
}