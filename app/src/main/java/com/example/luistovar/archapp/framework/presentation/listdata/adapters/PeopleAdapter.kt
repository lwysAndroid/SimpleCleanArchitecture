package com.example.luistovar.archapp.framework.presentation.listdata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.databinding.ItemPeopleBinding
import com.example.luistovar.archapp.framework.network.webservices.models.PeopleData

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.MyHolder>() {

    var peopleDataList: List<PeopleData?>? = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onclickItem: ((peopleData: PeopleData) -> Unit)? = null

    class MyHolder(
        myView: View,
        private val onClick: ((peopleData: PeopleData) -> Unit)?
    ) :
        RecyclerView.ViewHolder(myView) {

        private var binding: ItemPeopleBinding = ItemPeopleBinding.bind(myView)

        fun bind(peopleData: PeopleData) {
            binding.peopleContainer.setOnClickListener { onClick?.invoke(peopleData) }
            binding.tvPeopleName.text = peopleData.name
            binding.tvPeopleGender.text = peopleData.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return MyHolder(view, onclickItem)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        peopleDataList?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = peopleDataList?.size ?: 0
}
