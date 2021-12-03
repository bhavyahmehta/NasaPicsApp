package com.example.nasapicsappsample.ui.grid

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.nasapicsappsample.ui.base.BaseViewModel
import com.example.nasapicsappsample.data.Item
import com.example.nasapicsappsample.data.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor(
    private val repo: Repo,
) : BaseViewModel() {

    var itemLiveData = MutableLiveData<List<Item>>()

    fun getItems(context: Context) {
        launchThread {
            itemLiveData.postValue(repo.getItems(context))
        }
    }
}