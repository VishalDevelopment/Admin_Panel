package com.example.adminpanel.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adminpanel.ViewModels.MarsVm


@Composable
fun UserDetailScreen(data: MarsVm) {

    UserDetail(data)
}

@Composable

fun UserDetail(data: MarsVm) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(5.dp), modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {

            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(1f)) {
                Text(
                    text = "ID : ${data._res.value!!.user_id}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Name : ${data._res.value!!.name}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Text(
                    text = "Email : ${data._res.value!!.email}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Phone No : ${data._res.value!!.phone}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Text(
                    text = " Address : ${data._res.value!!.Address}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = " Account Creation : ${data._res.value!!.DateOfAccountCreation}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = " Approved : ${data._res.value!!.approved}",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                val context = LocalContext.current
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = {
                        Toast.makeText(context, "Approved ", Toast.LENGTH_SHORT).show()
                    }, colors = ButtonDefaults.buttonColors(Color.Green)) {
                        Text(text = "Approved", fontSize = 20.sp, color = Color.Black)
                    }
                    Button(onClick = {
                        Toast.makeText(context, "Block", Toast.LENGTH_SHORT).show()
                    }, colors = ButtonDefaults.buttonColors(Color.Red)) {
                        Text(text = "Block", fontSize = 20.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}