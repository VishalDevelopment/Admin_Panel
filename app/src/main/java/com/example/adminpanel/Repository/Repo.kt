package com.example.adminpanel.Repository

import android.util.Log
import com.example.adminpanel.Model.AllUsersItem
import com.example.adminpanel.Retrofit.retrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Repo() {
    var Mars = MutableStateFlow<List<AllUsersItem>>(emptyList())
    val MarsImages: StateFlow<List<AllUsersItem>>
        get() = Mars

    suspend fun getImages() {
        val Data = retrofitInstance.getInstance().getAllUsers()
        if (Data.isSuccessful && Data.body() != null) {
            Log.d("VisRepo", "${Data.body()}")
            Mars.emit(Data.body()!!)
        }
    }

    suspend fun addProduct(name: String, price: String, category: String, stack: Int) {
        val Data = retrofitInstance.getInstance().addProduct(name, price, category, stack)

        if (Data.isSuccessful) {
            Log.d("Vishal", "${Data.body()!!.success}")
        } else {
            Log.d("Vishal", "${Data.body()!!.success}")
        }
    }
}