package com.example.luistovar.archapp.presentation.common.basecomponents

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.luistovar.archapp.presentation.common.GoToOtherFragment

/**
 * BaseFragment
 *
 * Base fragment that contains commons methods and configuration that need or could be used
 * for all fragments in the app
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    /**
     * GoToOtherFragment instance to manage the navigation between fragments
     */
    protected var mGoToOtherFragment: GoToOtherFragment? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is GoToOtherFragment) {
            mGoToOtherFragment = context
        }
    }
}