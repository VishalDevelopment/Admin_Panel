package com.example.adminpanel.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, heightDp = 800, widthDp = 400)
fun AddProductScreen() {


       Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                var name = remember { mutableStateOf("") }
                var category = remember { mutableStateOf("") }
                var price = remember { mutableStateOf("") }
                var stock = remember { mutableStateOf("") }

                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    placeholder = { Text(text = "Product Name") },
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { category.value = it },
                    placeholder = { Text(text = "Category") },
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { price.value = it },
                    placeholder = { Text(text = "Price") },
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { stock.value = it },
                    placeholder = { Text(text = "Stock") },
                    modifier = Modifier.padding(5.dp)
                )
                val context = LocalContext.current
                Button(onClick = {
                    if (name.value !="" && category.value!="" && stock.value!="" && price.value!="" ){
                        Toast.makeText(context, "Good to Go ", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "Blank fills not allowed", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "Add Product")
                }
            }

    }
}