package com.miclaro.viewtypesrecycler_example.Data

import androidx.annotation.DrawableRes
import com.miclaro.viewtypesrecycler_example.R

data class CarData(
    val lstSections: List<CarSection>
)

data class CarSection(
    val detailSection: CarSectionDetails,
    val lstCars: List<Car>
)

data class CarSectionDetails(
    val title: String,
    @DrawableRes val icon: Int
)

data class Car(
    val name: String,
    val price: Int,
    val releaseYear: Int
)

val getListOfCars = CarData(
    listOf(
        CarSection(
            CarSectionDetails(
                "Carros", R.drawable.type_car_1
            ),
            listOf(
                Car(
                    "Car 1 type 1",10,1987
                ),
                Car(
                    "Car 2 type 1",25,1987
                )
            )
        ),
        CarSection(
            CarSectionDetails(
                "Mama vans", R.drawable.type_car_2
            ),
            listOf(
                Car(
                    "Car 1 type 2",30,2987
                ),
                Car(
                    "Car 2 type 2",45,3987
                )
            )
        ),
        CarSection(
            CarSectionDetails(
                "TROCAS", R.drawable.type_car_3
            ),
            listOf(
                Car(
                    "Car 1 type 3",50,1987
                ),
                Car(
                    "Car 2 type 3",65,1987
                )
            )
        ),
    )
)
