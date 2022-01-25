package com.miclaro.viewtypesrecycler_example.adapter

import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.miclaro.viewtypesrecycler_example.Data.CarListItem
import com.miclaro.viewtypesrecycler_example.Data.CarListSectionItem
import com.miclaro.viewtypesrecycler_example.R
import com.miclaro.viewtypesrecycler_example.databinding.ListItemBinding
import com.miclaro.viewtypesrecycler_example.databinding.SectionItemBinding

sealed class CarListViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

class CarSectionViewHolder(private val sectionItemBinding: SectionItemBinding) : CarListViewHolder(sectionItemBinding) {
    fun bindView(itemData: CarListSectionItem){
        sectionItemBinding.name.text = itemData.itemSection.title
        sectionItemBinding.icon.setImageResource(itemData.itemSection.icon)
    }
}

class CarItemViewHolder(private val carItemBinding: ListItemBinding) : CarListViewHolder(carItemBinding) {
    fun bindView(itemData: CarListItem){
        carItemBinding.name.text = itemData.itemCar.name

        carItemBinding.releaseYear.let {
            it.text = SpannableStringBuilder().bold {
                append(it.context.getString(R.string.release_year))
            }.append(": ").append(itemData.itemCar.releaseYear.toString())
        }

        carItemBinding.startingPrice.let {
            it.text = SpannableStringBuilder().bold {
                append(it.context.getString(R.string.starting_price))
            }.append(": ").append(itemData.itemCar.price.toString())
        }

    }
}