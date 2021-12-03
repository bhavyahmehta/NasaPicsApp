package com.example.nasapicsappsample.ui.grid

import androidx.databinding.ViewDataBinding
import com.example.nasapicsappsample.R
import com.example.nasapicsappsample.data.Item
import com.example.nasapicsappsample.databinding.ItemGridBinding
import com.example.nasapicsappsample.ui.base.BaseDiffCallback
import com.example.nasapicsappsample.ui.base.BaseListAdapter
import com.example.nasapicsappsample.ui.base.BaseViewHolder

class GridAdapter(private val itemClickListener: ItemClickListener) :
    BaseListAdapter<Item>(ItemDiffCallback()) {

    interface ItemClickListener {
        fun onItemClick(item: Item)
    }

    override fun getItemLayoutId(viewType: Int) = R.layout.item_grid

    override fun onBind(holder: BaseViewHolder): ViewDataBinding? =
        holder.getBinding(ItemGridBinding::class.java)
            ?.apply {
                val item = getCurrentItem(holder) ?: return@apply
                gridItem = item
                clickListener = itemClickListener
            }

}

class ItemDiffCallback : BaseDiffCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return (oldItem.date == newItem.date
                && oldItem.title == newItem.date
                && oldItem.copyright == newItem.copyright)
    }
}
