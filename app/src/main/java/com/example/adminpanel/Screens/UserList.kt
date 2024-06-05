package com.example.adminpanel.Screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adminpanel.Model.AllUsersItem
import com.example.adminpanel.ViewModels.MarsVm


@Composable
fun UserListScreen(viewModel: MarsVm, onClick: (AllUsersItem) -> Unit) {

    val data = viewModel.dataList.collectAsState()
    LazyColumn {
        items(data.value){
            UserList(viewModel,it,onClick)
        }
    }
}

@Composable
fun UserList(viewModel: MarsVm, detail: AllUsersItem, onClick: (data: AllUsersItem) -> Unit) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(5.dp), modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {

            Column(modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(1f)) {
                Text(
                    text = " Name : ${detail.name}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = " Email : ${detail.email}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                
                val context = LocalContext.current
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = {
                        Toast.makeText(context, "Approved ", Toast.LENGTH_SHORT).show()
                    }, colors = ButtonDefaults.buttonColors(Color.Unspecified)) {
                        Text(text = "Approved", fontSize = 20.sp, color = Color.Black)
                    }

                    Text(text = "More...", fontSize = 20.sp, color = Color.Black, modifier = Modifier.clickable {
                        onClick(detail)
                        viewModel.setData(detail)
                    })
                }
            }


        }

    }

}