package com.example.luistovar.archapp.presentation.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * GoToOtherFragment
 *
 * Interface with methods to manage the navigation between fragments, this should be implemented in
 * the Activity that will contain the fragments, and this implementation will be set
 * into the fragment on the attached method
 *
 */
interface GoToOtherFragment {

    /**
     * Variable that refer to the id of the container view for the fragments
     */
    val containerViewId: Int

    /**
     * Method do manage the navigation between fragments
     *
     * @param fragment The new fragment that will replace the current fragment
     * @param addToBackStackName
     * @param shouldAddToBackStackName boolean value to know if the transaction should be added to
     * the back stack
     */
    fun goToOtherFragment(
        fragment: Fragment,
        addToBackStackName: String = "",
        shouldAddToBackStackName: Boolean = true
    )

    /**
     * Method to get the id of the view which contains the fragments
     */
    @IdRes
    fun getFragmentContainerViewId(): Int = containerViewId

}