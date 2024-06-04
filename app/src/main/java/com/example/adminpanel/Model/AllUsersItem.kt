package com.example.adminpanel.Model

data class AllUsersItem(
    val Address: String,
    val Block: Int,
    val DateOfAccountCreation: String,
    val Level: Int,
    val PinCode: String,
    val approved: Int,
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val phone: String,
    val user_id: String
)