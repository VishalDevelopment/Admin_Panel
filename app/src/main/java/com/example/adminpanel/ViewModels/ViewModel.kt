package com.example.adminpanel.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adminpanel.Model.AllUsersItem
import com.example.adminpanel.Repository.Repo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Vm : ViewModel() {

    private val marsRepo = Repo()
    private  val res : MutableState<AllUsersItem?> = mutableStateOf(null)
    val _res: State<AllUsersItem?>
            get() = res
    fun setData(usersItem: AllUsersItem ){
        res.value = usersItem
    }

    val dataList: StateFlow<List<AllUsersItem>> = marsRepo.MarsImages
    init {
        viewModelScope.launch {
            marsRepo.getImages()
        }
    }

    suspend fun addProduct(name:String, price:String , category: String , stack:Int){
        marsRepo.addProduct(name, price, category, stack)
    }
}