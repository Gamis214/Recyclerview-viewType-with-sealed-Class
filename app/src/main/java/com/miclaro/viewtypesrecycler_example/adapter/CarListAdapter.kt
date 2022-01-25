package com.miclaro.viewtypesrecycler_example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miclaro.viewtypesrecycler_example.Data.CarListData
import com.miclaro.viewtypesrecycler_example.Data.CarListItem
import com.miclaro.viewtypesrecycler_example.Data.CarListSectionItem
import com.miclaro.viewtypesrecycler_example.databinding.ListItemBinding
import com.miclaro.viewtypesrecycler_example.databinding.SectionItemBinding

class CarListAdapter(private val lstCars: List<CarListData>) : RecyclerView.Adapter<CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        return when(viewType) {
            CarListViewType.CAR_VIEW.ordinal -> {
                CarItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            CarListViewType.SECTION_VIEW.ordinal ->{
                CarSectionViewHolder(SectionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
            else -> {
                CarSectionViewHolder(SectionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        when(val dataForCurrentPosition = lstCars[position]){
            is CarListItem -> {
                (holder as CarItemViewHolder).bindView(dataForCurrentPosition)
            }
            is CarListSectionItem -> {
                (holder as CarSectionViewHolder).bindView(dataForCurrentPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(lstCars[position]){
            is CarListItem -> CarListViewType.CAR_VIEW.ordinal
            is CarListSectionItem -> CarListViewType.SECTION_VIEW.ordinal
        }
    }

    override fun getItemCount(): Int {
        return lstCars.size
    }

}