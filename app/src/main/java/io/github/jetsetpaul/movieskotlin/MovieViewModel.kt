package io.github.jetsetpaul.movieskotlin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by pauljoiner on 8/1/18.
 */
class MovieViewModel : ViewModel(){
    val movies : MutableLiveData<List<Movie>> by lazy {
        loadMovies()
        return@lazy MutableLiveData<List<Movie>>()
    }

    fun loadMovies() {
        val response = MyRetrofit.movieApi.getTopMovies()
        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val tmdbResponse = response.body()!!
                movies.value = tmdbResponse.results
                Log.d("TAG", movies.toString())

            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

                //recreate logic from MainActivity
    }
}