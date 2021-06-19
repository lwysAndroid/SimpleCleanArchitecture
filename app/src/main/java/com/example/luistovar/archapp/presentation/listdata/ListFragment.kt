package com.example.luistovar.archapp.presentation.listdata

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.androidframework.network.NetWorkConfiguration
import com.example.luistovar.archapp.androidframework.network.webservices.StarWarsApi
import com.example.luistovar.archapp.data.datasources.remote.impl.PeopleListSwDataSourceRemoteImpl
import com.example.luistovar.archapp.data.repositories.implementation.PeopleListSwRepositoryImpl
import com.example.luistovar.archapp.domain.models.PeopleData
import com.example.luistovar.archapp.domain.usecases.implementation.PeopleListSwUseCaseImpl
import com.example.luistovar.archapp.presentation.common.basecomponents.BaseFragment
import com.example.luistovar.archapp.presentation.listdata.adapters.PeopleAdapter
import kotlinx.android.synthetic.main.list_fragment.*

/**
 * ListFragment
 *
 * Fragment to show a list retrieved from a service
 */
class ListFragment : BaseFragment(R.layout.list_fragment) {

    companion object {
        fun newInstance() = ListFragment()
    }

    // This is a dependency injection by hand and should be done by other tool like Dagger 2, Hilt or Koin
    private var starWarsApi: StarWarsApi = NetWorkConfiguration.getStarWarsApi()
    private var peopleListSwDataSource = PeopleListSwDataSourceRemoteImpl(starWarsApi)
    private var peopleListSwRepository = PeopleListSwRepositoryImpl(peopleListSwDataSource)
    private var peopleListSwUseCase = PeopleListSwUseCaseImpl(peopleListSwRepository)
    private var listViewModelProviderFactory = ListViewModelProviderFactory(peopleListSwUseCase)

    /**
     * ListViewModel instance
     */
    private lateinit var viewModel: ListViewModel

    /**
     * Adapter to manage the list and show data on Recycler View
     */
    private val peopleAdapter = PeopleAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getPeopleListSwResource()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
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

    /**
     * Method to show error
     */
    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Method to handle click on the items of the recycler view
     */
    private fun onClickOnItem(peopleData: PeopleData) {
        Toast.makeText(context, "name: ${peopleData.name}", Toast.LENGTH_SHORT).show()
    }


}