package com.example.nasapicsappsample.base

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    open fun initIntentArgs(intent: Intent? = null, bundle: Bundle? = null) {

    }

    fun launchThread(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend CoroutineScope.() -> Unit,
    ) =
        viewModelScope.launch(context, start = CoroutineStart.DEFAULT, block)

}