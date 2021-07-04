package com.example.luistovar.archapp.framework.presentation.common.basecomponents

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * BaseFragment
 *
 * Base fragment that contains commons methods and configuration that need or could be used
 * for all fragments in the app
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

}