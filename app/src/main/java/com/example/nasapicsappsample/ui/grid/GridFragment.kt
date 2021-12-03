package com.example.nasapicsappsample.ui.grid

import android.util.Log
import com.example.nasapicsappsample.ui.base.BaseFragment
import com.example.nasapicsappsample.R
import com.example.nasapicsappsample.data.Item
import com.example.nasapicsappsample.databinding.FragmentGridBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GridFragment : BaseFragment<GridViewModel, FragmentGridBinding>(),
    GridAdapter.ItemClickListener {

    override fun getLayoutId() = R.layout.fragment_grid

    override fun getViewModelClass() = GridViewModel::class.java

    private lateinit var gridAdapter: GridAdapter

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getItems(requireContext())
    }

    override fun observeViewModel() {
        super.observeViewModel()
        gridAdapter = GridAdapter(this)
        viewModel.itemLiveData.observe(viewLifecycleOwner, { items ->
            gridAdapter.submitList(items)
        })
    }

    override fun initViews() {
        super.initViews()
        binding.apply {
            gridList.adapter = gridAdapter
        }
    }

    override fun onItemClick(item: Item) {

    }
}