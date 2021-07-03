package com.example.luistovar.archapp.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.MainFragmentBinding
import com.example.luistovar.archapp.domain.models.User
import com.example.luistovar.archapp.presentation.common.basecomponents.BaseFragment

/**
 * MainFragment
 *
 * Initial fragment from which the app flows are triggered
 */
class MainFragment : BaseFragment(R.layout.main_fragment) {


    /**
     * View Binding instance
     */
    private lateinit var binding: MainFragmentBinding
    /**
     * MainViewModel instance
     */
    private lateinit var viewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        setupView()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
    private fun setupView() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnGoListScreen.setOnClickListener {
            val action =
                MainFragmentDirections.actionMainFragmentToListFragment(500, User("Luis", "Tovar"))
            findNavController().navigate(action)
        }
    }

}