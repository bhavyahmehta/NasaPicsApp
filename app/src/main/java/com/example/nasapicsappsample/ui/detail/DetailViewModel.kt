package com.example.nasapicsappsample.ui.detail

import android.content.Intent
import android.os.Bundle
import com.example.nasapicsappsample.data.Item
import com.example.nasapicsappsample.ui.base.BaseViewModel

class DetailViewModel:BaseViewModel() {

    var item: Item? = null

    override fun initIntentArgs(intent: Intent?, bundle: Bundle?) {
        super.initIntentArgs(intent, bundle)
        if (bundle == null) {
            return
        }
        item = DetailFragmentArgs.fromBundle(bundle).item
    }
}