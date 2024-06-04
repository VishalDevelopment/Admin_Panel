package com.example.adminpanel.Retrofit

import com.example.adminpanel.Model.AllUsers
import com.example.adminpanel.Model.AllUsersItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("getAllUsers")
    fun getUsers(): Response<List<AllUsersItem>>

}


 object RetrofitHelper{
    var apiService: ApiService? = null
    fun getInstance(): ApiService {
        if (apiService == null) {
            apiService = Retrofit.Builder().baseUrl("https://vishal8851.pythonanywhere.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiService::class.java)
        }
        return apiService!!
    }
}