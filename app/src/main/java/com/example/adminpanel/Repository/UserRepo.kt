package com.example.adminpanel.Repository

import android.service.autofill.UserData
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.adminpanel.Model.AllUsers
import com.example.adminpanel.Model.AllUsersItem
import com.example.adminpanel.Retrofit.ApiService
import com.example.adminpanel.Retrofit.RetrofitHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserRepo(){

    val users = MutableStateFlow<List<AllUsersItem>>(emptyList())
    val userData :StateFlow<List<AllUsersItem>>
        get() = users

    suspend fun getUsers(){
        val response = RetrofitHelper.getInstance().getUsers()
        if (response.isSuccessful && response.body()!=null){
            Log.d("Vrp","${response.body()}")
            users.emit(response.body()!!)
        }
    }

}