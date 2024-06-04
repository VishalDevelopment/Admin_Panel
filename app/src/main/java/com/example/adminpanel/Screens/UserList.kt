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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun UserList(userId: String, email: String) {

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
                    text = "id : 909uhgj35",
                    fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "name : Vishal",
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

                    Button(onClick = {
                        Toast.makeText(context, "Blocked ", Toast.LENGTH_SHORT).show()
                    }, colors = ButtonDefaults.buttonColors(Color.Unspecified)) {
                        Text(text = "Blocked", fontSize = 20.sp, color = Color.Black)
                    }
                }
            }


        }
    }

}