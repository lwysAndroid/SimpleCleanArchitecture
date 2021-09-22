package com.example.luistovar.archapp.presentation.listdata

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.ListFragmentBinding
import com.example.luistovar.archapp.domain.models.PeopleSWDataDomain
import com.example.luistovar.archapp.domain.models.PeopleSWDomain
import com.example.luistovar.archapp.domain.models.Resource
import com.example.luistovar.archapp.presentation.listdata.models.User
import com.example.luistovar.archapp.presentation.listdata.adapters.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * ListFragment
 *
 * Fragment to show a list retrieved from a service
 */
@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {

    /**
     * View Binding instance
     */
    private lateinit var binding: ListFragmentBinding

    /**
     * Args to manage the arguments passed
     */
    private val args: ListFragmentArgs by navArgs()

    /**
     * ListViewModel instance
     */
    private val mViewModel: ListViewModel by viewModels()

    /**
     * Adapter to manage the list and show data on Recycler View
     */
    private val peopleAdapter = PeopleAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ListFragmentBinding.bind(view)
        setupView()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getPeopleListSwResource()
    }

    /**
     * Method to set listeners and the init configuration of the view
     */
    private fun setupView() {
        peopleAdapter.onclickItem = this::onClickOnItem
        binding.rVPeople.adapter = peopleAdapter
        mViewModel.peopleListSwLiveData.observe(viewLifecycleOwner) {
            managePeopleListSw(it)
        }
        showArgs()
    }

    private fun managePeopleListSw(resource: Resource<PeopleSWDomain>) {
        binding.progressBar.visibility = View.GONE
        when (resource) {
            is Resource.Success -> {
                peopleAdapter.peopleDataList = resource.data!!.peopleSWDataDomainList
            }
            is Resource.Error -> {
                resource.failure!!.errorMessage?.let { showError(it) }
            }
            is Resource.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    /**
     * Method to show the args passed using the Navigation Component
     */
    private fun showArgs() {
        val user = args.currentUser as User
        Toast.makeText(
            context,
            "Amount: ${args.amount}, Current User: ${user.firstName} ${user.lastName}",
            Toast.LENGTH_SHORT
        ).show()
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
    private fun onClickOnItem(peopleSWDataDomain: PeopleSWDataDomain) {
        Toast.makeText(context, "name: ${peopleSWDataDomain.name}", Toast.LENGTH_SHORT).show()
    }


}