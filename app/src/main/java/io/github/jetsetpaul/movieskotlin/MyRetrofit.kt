package io.github.jetsetpaul.movieskotlin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pauljoiner on 7/18/18.
 */
object MyRetrofit {
    private val logging = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder()
    private val retrofit: Retrofit
    val movieApi: MovieAPI

    init {
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)
        retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        movieApi = retrofit.create(MovieAPI::class.java)
    }

}