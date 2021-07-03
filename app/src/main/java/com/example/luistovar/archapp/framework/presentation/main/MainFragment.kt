package com.example.luistovar.archapp.framework.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.MainFragmentBinding
import com.example.luistovar.archapp.domain.models.User
import com.example.luistovar.archapp.framework.presentation.common.basecomponents.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainFragment
 *
 * Initial fragment from which the app flows are triggered
 */
@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.main_fragment) {


    /**
     * View Binding instance
     */
    private lateinit var binding: MainFragmentBinding
    /**
     * MainViewModel instance
     */
    private val mViewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        setupView()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
    private fun setupView() {
        binding.btnGoListScreen.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToListFragment(500, User("Luis", "Tovar"))
            findNavController().navigate(action)
        }
    }

}