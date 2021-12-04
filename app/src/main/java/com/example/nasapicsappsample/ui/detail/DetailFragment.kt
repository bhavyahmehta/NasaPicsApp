package com.example.nasapicsappsample.ui.detail

import androidx.core.widget.NestedScrollView
import com.example.nasapicsappsample.R
import com.example.nasapicsappsample.databinding.FragmentDetailBinding
import com.example.nasapicsappsample.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {

    override fun getLayoutId() = R.layout.fragment_detail

    override fun getViewModelClass() = DetailViewModel::class.java

    override fun showToolbar() = false

    override fun initViews() {
        super.initViews()
        binding.apply {
            val item = viewModel.item
            if (item != null) {
                detailItem = item

                var isToolbarShown = false
                detailScrollview.setOnScrollChangeListener(
                    NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
                        val shouldShowToolbar = scrollY > toolbar.height
                        if (isToolbarShown != shouldShowToolbar) {
                            isToolbarShown = shouldShowToolbar
                            appbar.isActivated = shouldShowToolbar
                            toolbarLayout.isTitleEnabled = shouldShowToolbar
                        }
                    }
                )

                toolbar.setNavigationOnClickListener { view ->
                    screenNavigator.navigateUp()
                }
            }
        }
    }
}