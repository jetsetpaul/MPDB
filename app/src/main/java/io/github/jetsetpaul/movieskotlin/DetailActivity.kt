package io.github.jetsetpaul.movieskotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)


        val response = MyRetrofit.movieApi.getMovieDetails(movieId)
        response.enqueue(object: Callback<DetailResponse>{
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                val tmdbResponse = response.body()
                val overview = tmdbResponse?.overview

                val detailText = findViewById<TextView>(R.id.detail_text)
                detailText.text = overview
                Log.d("TAG", overview)
            }

            override fun onFailure(call: Call<DetailResponse>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

    companion object {
        private const val EXTRA_MOVIE_ID = "extra_id"

        /**
         *
         *
         * @param movieId id of the Movie whose details will be displayed
         */
        fun createIntent(movieId: String, context: Context) : Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }
}
