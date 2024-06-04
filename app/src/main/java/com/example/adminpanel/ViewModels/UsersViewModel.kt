package com.example.adminpanel.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminpanel.Model.AllUsersItem
import com.example.adminpanel.Repository.UserRepo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel:ViewModel (){

    init{
        viewModelScope.launch {
            UserRepo().getUsers()
        }
        Log.d("Vvm","${UserRepo().userData.value}")
    }
    val UserList:StateFlow<List<AllUsersItem>> = UserRepo().userData

}

