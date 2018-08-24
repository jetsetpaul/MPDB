package io.github.jetsetpaul.movieskotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var movies = listOf<Movie>()
    private var mainMenuOptions = mutableListOf<Filter>()
    private var genreFilters = mutableListOf<String>()
    private var yearReleasedFilters = mutableListOf<String>()
    private var popularityFilters = mutableListOf<String>()
    private var ratingFilters = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillSubFilters()
        mainMenuOptions.add(Filter("Genre", genreFilters))
        mainMenuOptions.add(Filter("Year Released", yearReleasedFilters))
        mainMenuOptions.add(Filter("Popularity", popularityFilters))
        mainMenuOptions.add(Filter("Rating", ratingFilters))

        displayFilters()
//        val response = MyRetrofit.movieApi.getTopMovies()
//        response.enqueue(object : Callback<MovieResponse>{
//            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
//                val tmdbResponse = response.body()!!
//                movies = tmdbResponse.results
//                Log.d("TAG", movies.toString())
//                displayTopMovies()
//            }
//
//            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

    }

    private fun displayFilters(){
        val filterList = findViewById<RecyclerView>(R.id.filter_list)
        filterList.layoutManager = LinearLayoutManager(this)

        filterList.adapter = FilterListAdapter(mainMenuOptions, {filter: Filter -> navigateToSubfilter(filter)})
    }



    private fun navigateToSubfilter(filter: Filter){
        val subFilterIntent = SubfilterActivity.createIntent(filter, this)
        startActivity(subFilterIntent)
    }

    fun fillSubFilters() {
        genreFilters.add("Action")
        genreFilters.add("Adventure")
        genreFilters.add("Animation")
        genreFilters.add("Comedy")
        genreFilters.add("Crime")
        genreFilters.add("Documentary")
        genreFilters.add("Drama")
        genreFilters.add("Family")
        genreFilters.add("Fantasy")
        genreFilters.add("Foreign")
        genreFilters.add("History")
        genreFilters.add("Horror")
        genreFilters.add("Music")
        genreFilters.add("Mystery")
        genreFilters.add("Romance")
        genreFilters.add("Science Fiction")
        genreFilters.add("TV Movie")
        genreFilters.add("Thriller")
        genreFilters.add("War")
        genreFilters.add("Western")
        popularityFilters.add("< 100 votes")
        popularityFilters.add("< 500 votes")
        popularityFilters.add("< 1000 votes")
        popularityFilters.add("< 5000 votes")
        yearReleasedFilters.add("2010s")
        yearReleasedFilters.add("2000s")
        yearReleasedFilters.add("1990s")
        yearReleasedFilters.add("1980s")
        yearReleasedFilters.add("1970s")
        yearReleasedFilters.add("1960s")
        yearReleasedFilters.add("1950s")
        yearReleasedFilters.add("1940s")
        yearReleasedFilters.add("1930s")
        yearReleasedFilters.add("1920s")
        yearReleasedFilters.add("1910s")
        ratingFilters.add("10/10")
        ratingFilters.add("9/10")
        ratingFilters.add("8/10")
        ratingFilters.add("7/10")
        ratingFilters.add("6/10")
        ratingFilters.add("5/10")
        ratingFilters.add("4/10")
        ratingFilters.add("3/10")
        ratingFilters.add("2/10")
        ratingFilters.add("1/10")
    }
}
