package com.miclaro.viewtypesrecycler_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.miclaro.viewtypesrecycler_example.Data.CarListData
import com.miclaro.viewtypesrecycler_example.Data.getListOfCars
import com.miclaro.viewtypesrecycler_example.adapter.CarListAdapter
import com.miclaro.viewtypesrecycler_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityBinding = ActivityMainBinding.inflate(layoutInflater,null,false)
        setContentView(mainActivityBinding.root)

        mainActivityBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainActivityBinding.recyclerView.adapter = CarListAdapter(CarListData.fromCarData(getListOfCars))
    }
}