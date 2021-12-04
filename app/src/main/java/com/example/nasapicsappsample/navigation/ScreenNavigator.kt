package com.example.nasapicsappsample.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.nasapicsappsample.R
import com.example.nasapicsappsample.data.Item

class ScreenNavigator (private var navController: NavController) {

    private fun slideLeftAnimOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_left)
        .setExitAnim(R.anim.wait_anim)
        .setPopEnterAnim(R.anim.wait_anim)
        .setPopExitAnim(R.anim.slide_right).build()

    fun openDetailScreen(item: Item) {
        navController.navigate(R.id.nav_detail_fragment, Bundle().apply {
            putParcelable(BundleParams.ITEM, item)
        }, slideLeftAnimOptions())
    }

    fun navigateUp() {
        navController.navigateUp()
    }

}