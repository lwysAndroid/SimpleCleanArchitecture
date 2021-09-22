package com.example.luistovar.archapp.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.HomeFragmentBinding
import com.example.luistovar.archapp.presentation.listdata.models.User
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainFragment
 *
 * Initial fragment from which the app flows are triggered
 */
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {


    /**
     * View Binding instance
     */
    private lateinit var binding: HomeFragmentBinding
    /**
     * MainViewModel instance
     */
    private val mViewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(view)
        setupView()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
    private fun setupView() {
        binding.btnGoListScreen.setOnClickListener {
            val action =
                HomeFragmentDirections.actionMainFragmentToListFragment(500, User("Luis", "Tovar"))
            findNavController().navigate(action)
        }
    }

}