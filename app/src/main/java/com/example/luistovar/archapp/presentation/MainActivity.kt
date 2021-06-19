package com.example.luistovar.archapp.presentation

import android.os.Bundle
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.presentation.common.basecomponents.BaseActivity
import com.example.luistovar.archapp.presentation.home.MainFragment

/**
 * MainActivity
 *
 * Activity that contains the root view in which will be set all the fragments
 */
class MainActivity : BaseActivity(R.layout.main_activity) {

    /**
     * Variable that refer to the id of the container view for the fragments
     */
    override val containerViewId: Int
        get() = R.id.container


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(getFragmentContainerViewId(), MainFragment.newInstance())
                .commitNow()
        }

    }

}