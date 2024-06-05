package com.example.adminpanel.Retrofit

import com.example.adminpanel.Model.AddProduct
import com.example.adminpanel.Model.AllUsersItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://vishal8851.pythonanywhere.com"

interface ApiServices {
    @GET("/getAllUsers")
    suspend fun getAllUsers(): Response<List<AllUsersItem>>

    @FormUrlEncoded
    @POST("/addProduct")
    suspend fun addProduct(
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("category") category: String,
        @Field("stack") stack: Int,
    ): Response<AddProduct>

}

object retrofitInstance {
    var INSTANCE: ApiServices? = null

    fun getInstance(): ApiServices {
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create()
                ).build().create(ApiServices::class.java)
            }
        }
        return INSTANCE!!
    }
}