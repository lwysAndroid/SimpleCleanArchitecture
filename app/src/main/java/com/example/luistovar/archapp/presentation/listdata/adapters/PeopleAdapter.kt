package com.example.luistovar.archapp.presentation.listdata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luistovar.archapp.R
import com.example.luistovar.archapp.domain.models.PeopleData
import kotlinx.android.synthetic.main.item_people.view.*

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.MyHolder>() {

    var peopleDataList: List<PeopleData?>? = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onclickItem: ((peopleData: PeopleData) -> Unit)? = null

    class MyHolder(
        private val myView: View,
        private val onClick: ((peopleData: PeopleData) -> Unit)?
    ) :
        RecyclerView.ViewHolder(myView) {

        fun bind(peopleData: PeopleData) {
            myView.peopleContainer.setOnClickListener { onClick?.invoke(peopleData) }
            myView.tvPeopleName.text = peopleData.name
            myView.tvPeopleGender.text = peopleData.gender
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
