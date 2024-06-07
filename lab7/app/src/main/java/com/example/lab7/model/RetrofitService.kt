package com.example.lab7.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://6663173a62966e20ef0b5602.mockapi.io")  // Đảm bảo URL có http:// hoặc https:// và kết thúc bằng dấu "/"
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}
