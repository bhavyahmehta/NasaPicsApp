package com.example.nasapicsappsample.ui.grid

import android.util.Log
import com.example.nasapicsappsample.base.BaseFragment
import com.example.nasapicsappsample.R
import com.example.nasapicsappsample.databinding.FragmentGridBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GridFragment: BaseFragment<GridViewModel, FragmentGridBinding>() {

    override fun getLayoutId() = R.layout.fragment_grid

    override fun getViewModelClass() = GridViewModel::class.java

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getItems(requireContext())
    }

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.itemLiveData.observe(viewLifecycleOwner,{ items ->
            Log.e("data==",""+items.size)
        })
    }
}