package com.example.luistovar.archapp.framework.presentation.common.basecomponents

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * BaseActivity
 *
 * Base activity that contains commons methods and configuration that need or could be used
 * for all activities in the app
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {


}