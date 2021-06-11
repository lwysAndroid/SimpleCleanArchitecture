package com.example.luistovar.archapp.presentation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.presentation.MainActivity
import com.example.luistovar.archapp.presentation.common.GoToOtherFragment
import com.example.luistovar.archapp.presentation.listdata.ListFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance(goToOtherFragment: GoToOtherFragment?) = MainFragment().apply {
            this.goToOtherFragment = goToOtherFragment
        }
    }

    private var goToOtherFragment: GoToOtherFragment? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        btnGoListScreen.setOnClickListener {
            goToOtherFragment?.goToOtherFragment(ListFragment.newInstance(goToOtherFragment))
        }
    }

}