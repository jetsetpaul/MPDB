package io.github.jetsetpaul.movieskotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by pauljoiner on 6/22/18.
 */
interface MovieAPI {
    @GET("movie/popular$API_KEY")
    fun getTopMovies(): Call<MovieResponse>

    @GET("movie/{id}$API_KEY")
    fun getMovieDetails(@Path("id") movieId: String): Call<DetailResponse>

    companion object {
        const val API_KEY = "?api_key=e14343540e4d2cbfb1ab77faaca16fb8"

    }
}