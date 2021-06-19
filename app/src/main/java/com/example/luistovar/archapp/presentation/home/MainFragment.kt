package com.example.luistovar.archapp.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.presentation.common.basecomponents.BaseFragment
import com.example.luistovar.archapp.presentation.listdata.ListFragment
import kotlinx.android.synthetic.main.main_fragment.*

/**
 * MainFragment
 *
 * Initial fragment from which the app flows are triggered
 */
class MainFragment : BaseFragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    /**
     * MainViewModel instance
     */
    private lateinit var viewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
    private fun setupView() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        btnGoListScreen.setOnClickListener {
            mGoToOtherFragment?.goToOtherFragment(ListFragment.newInstance())
        }
    }

}