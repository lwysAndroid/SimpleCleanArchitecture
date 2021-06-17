package com.example.luistovar.archapp.presentation.listdata

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.androidframework.network.NetWorkConfiguration
import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import com.example.luistovar.archapp.data.datasources.local.PeopleListSwDataSourceRemoteImpl
import com.example.luistovar.archapp.data.repositories.implementation.PeopleListSwRepositoryImpl
import com.example.luistovar.archapp.domain.models.PeopleData
import com.example.luistovar.archapp.domain.usecases.implementation.PeopleListSwUseCaseImpl
import com.example.luistovar.archapp.presentation.common.GoToOtherFragment
import com.example.luistovar.archapp.presentation.listdata.adapters.PeopleAdapter
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    companion object {
        fun newInstance(goToOtherFragment: GoToOtherFragment?) = ListFragment().apply {
            this.goToOtherFragment = goToOtherFragment
        }
    }

    private var starWarsApi: StarWarsApi = NetWorkConfiguration.getStarWarsApi()
    private var peopleListSwDataSource = PeopleListSwDataSourceRemoteImpl(starWarsApi)
    private var peopleListSwRepository = PeopleListSwRepositoryImpl(peopleListSwDataSource)
    private var peopleListSwUseCase = PeopleListSwUseCaseImpl(peopleListSwRepository)
    private var listViewModelProviderFactory = ListViewModelProviderFactory(peopleListSwUseCase)

    private var goToOtherFragment: GoToOtherFragment? = null
    private lateinit var viewModel: ListViewModel
    private val peopleAdapter = PeopleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPeopleListSwResource()
    }

    private fun setupView() {
        viewModel =
            ViewModelProvider(this, listViewModelProviderFactory).get(ListViewModel::class.java)

        peopleAdapter.onclickItem = this::onClickOnItem
        rVPeople.adapter = peopleAdapter
        viewModel.peopleListSwLiveData.observe(viewLifecycleOwner) { peopleList ->
            peopleAdapter.peopleDataList = peopleList?.peopleData
        }

        viewModel.showError.observe(viewLifecycleOwner) { error ->
            error?.let { showError(it) }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun onClickOnItem(peopleData: PeopleData) {
        Toast.makeText(context, "name: ${peopleData.name}", Toast.LENGTH_SHORT).show()

    }


}