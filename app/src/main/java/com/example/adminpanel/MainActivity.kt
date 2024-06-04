package com.example.adminpanel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adminpanel.Retrofit.ApiService
import com.example.adminpanel.Retrofit.RetrofitHelper
import com.example.adminpanel.ViewModels.UsersViewModel
import com.example.adminpanel.ui.theme.AdminPanelTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            AdminPanelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    val viewModel : UsersViewModel = viewModel()
//                    val usersList = viewModel.UserList.collectAsState(initial = emptyList())
//                    Log.d("vm","${usersList.value}")

                    val apiServices = RetrofitHelper.getInstance().getUsers()
                    Log.d("Vishal","${apiServices.body()}")


                }
            }
        }
    }


}



