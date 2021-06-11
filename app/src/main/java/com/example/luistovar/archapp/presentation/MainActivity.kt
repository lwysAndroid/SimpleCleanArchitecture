package com.example.luistovar.archapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.presentation.common.GoToOtherFragment
import com.example.luistovar.archapp.presentation.home.MainFragment

class MainActivity : AppCompatActivity(), GoToOtherFragment {

    private val container: Int = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(container, MainFragment.newInstance(this))
                .commitNow()
        }
    }

    fun changeFragment(fragment: Fragment) {

    }

    override fun goToOtherFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .addToBackStack("")
            .commit()
    }
}