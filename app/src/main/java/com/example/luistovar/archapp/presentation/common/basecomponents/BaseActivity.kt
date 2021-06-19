package com.example.luistovar.archapp.presentation.common.basecomponents

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.luistovar.archapp.presentation.common.GoToOtherFragment

/**
 * BaseActivity
 *
 * Base activity that contains commons methods and configuration that need or could be used
 * for all activities in the app
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId),
    GoToOtherFragment {


    /**
     * Method do manage the navigation between fragments
     *
     * @param fragment The new fragment that will replace the current fragment
     * @param addToBackStackName
     * @param shouldAddToBackStackName boolean value to know if the transaction should be added to
     * the back stack
     */
    override fun goToOtherFragment(
        fragment: Fragment,
        addToBackStackName: String,
        shouldAddToBackStackName: Boolean
    ) {
        supportFragmentManager.beginTransaction()
            .replace(getFragmentContainerViewId(), fragment)
            .addToBackStack("")
            .commit()
    }

}