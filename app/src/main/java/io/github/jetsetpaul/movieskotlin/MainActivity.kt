package io.github.jetsetpaul.movieskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var movies = listOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.themoviedb.org/3/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        val movieApi = retrofit.create(MovieAPI::class.java)

        val response = MyRetrofit.movieApi.getTopMovies()
        response.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val tmdbResponse = response.body()!!
                movies = tmdbResponse.results
                Log.d("TAG", movies.toString())
                displayTopMovies()
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    private fun displayTopMovies() {
        val topMovieList = findViewById<RecyclerView>(R.id.top_movie_list)
        topMovieList.layoutManager = LinearLayoutManager(this)

        topMovieList.adapter = MovieListAdapter(movies, {movie: Movie -> navigateToDetail(movie.id) })
    }

    private fun navigateToDetail(id: String) {
        Log.d("TAG", "activity launching")

        val detailIntent = DetailActivity.createIntent(id, this)
        startActivity(detailIntent)

    }
}
