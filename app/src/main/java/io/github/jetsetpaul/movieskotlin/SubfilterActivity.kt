package io.github.jetsetpaul.movieskotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by pauljoiner on 8/21/18.
 */
class SubfilterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)

    }

    companion object {
        private const val SUB_FILTERS = "subfilters"

        /**
         *
         *
         * @param movieId id of the Movie whose details will be displayed
         */
        fun createIntent(filter: Filter, context: Context) : Intent {
            val intent = Intent(context, SubfilterActivity::class.java)
            intent.putExtra(SUB_FILTERS, filter.subfilters.toString())
            return intent
        }
    }
}