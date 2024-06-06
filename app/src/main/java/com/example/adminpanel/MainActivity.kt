package com.example.adminpanel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adminpanel.Screens.AddProductScreen
import com.example.adminpanel.Screens.UserDetailScreen
import com.example.adminpanel.Screens.UserListScreen
import com.example.adminpanel.ViewModels.Vm
import com.example.adminpanel.ui.theme.AdminPanelTheme

class MainActivity : ComponentActivity() {


    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            AdminPanelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel:Vm = viewModel()


                    App()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun App() {
        val viewModel: Vm = viewModel()

        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = "Admin Panel",
                        fontFamily = FontFamily.SansSerif,
                        color = Color.White
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    Color.Black
                ), navigationIcon = { // Add the icon here
                    IconButton(onClick = { navController.navigate("addproduct") }) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
                )
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(navController = navController, startDestination = "allUsers") {
                    composable(route = "allUsers") {
                        UserListScreen(viewModel) {
                            navController.navigate("userdetail/${it}")
                        }
                    }
                    composable(route = "userdetail/{data}") {
                        UserDetailScreen(viewModel)
                    }
                    composable(route = "addproduct") {
                        AddProductScreen(viewModel)
                    }
                }
            }
        }
    }
}







