package com.example.luistovar.archapp.presentation.listdata

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.ListFragmentBinding
import com.example.luistovar.archapp.domain.models.PeopleData
import com.example.luistovar.archapp.domain.models.User
import com.example.luistovar.archapp.presentation.common.basecomponents.BaseFragment
import com.example.luistovar.archapp.presentation.listdata.adapters.PeopleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * ListFragment
 *
 * Fragment to show a list retrieved from a service
 */
class ListFragment : BaseFragment(R.layout.list_fragment) {

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
    private val mViewModel: ListViewModel by viewModel()

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
        mViewModel.peopleListSwLiveData.observe(viewLifecycleOwner) { peopleList ->
            peopleAdapter.peopleDataList = peopleList?.peopleData
        }

        mViewModel.showError.observe(viewLifecycleOwner) { error ->
            error?.let { showError(it) }
        }

        mViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
        showArgs()
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
    private fun onClickOnItem(peopleData: PeopleData) {
        Toast.makeText(context, "name: ${peopleData.name}", Toast.LENGTH_SHORT).show()
    }


}