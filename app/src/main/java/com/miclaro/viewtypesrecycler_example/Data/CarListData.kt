package com.miclaro.viewtypesrecycler_example.Data

sealed class CarListData{
    companion object{
        fun fromCarData(carData: CarData) : List<CarListData>{
            val carsList = mutableListOf<CarListData>()
            carData.lstSections.forEach { carSection ->
                carsList.add(CarListSectionItem(carSection.detailSection))
                carSection.lstCars.forEach{ car ->
                    carsList.add(CarListItem(car))
                }
            }
            return carsList
        }
    }
}

data class CarListSectionItem(val itemSection: CarSectionDetails) : CarListData()
data class CarListItem(val itemCar: Car) : CarListData()
