package com.example.nasapicsappsample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nasapicsappsample.MainActivity

abstract class BaseFragment<VIEW_MODEL, VIEW_BINDING> :
    Fragment() where VIEW_MODEL : BaseViewModel, VIEW_BINDING : ViewDataBinding {

    open lateinit var binding: VIEW_BINDING
    open lateinit var viewModel: VIEW_MODEL

    val mainActivity get() = activity as? MainActivity
    val navController get() = findNavController()

    abstract fun getLayoutId(): Int
    abstract fun getViewModelClass(): Class<out VIEW_MODEL>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId() == -1) {
            return super.onCreateView(inflater, container, savedInstanceState)
        }
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        observeViewModel()
        initViews()
        initClickListeners()
    }

    open fun createViewModel(): VIEW_MODEL = ViewModelProvider(this)[getViewModelClass()]
    open fun initClickListeners() {}
    open fun initViews() {}
    open fun showToolbar() = true

    open fun initViewModel() {
        viewModel = createViewModel()
        viewModel.initIntentArgs(intent = null, bundle = arguments)
    }

    open fun observeViewModel() {
    }

    fun finish() {
        findNavController().navigateUp()
    }
}