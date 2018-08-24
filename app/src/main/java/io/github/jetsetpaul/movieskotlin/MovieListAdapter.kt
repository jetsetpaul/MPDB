package io.github.jetsetpaul.movieskotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by pauljoiner on 6/30/18.
 */
class MovieListAdapter(val items: List<Movie>, private val itemClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val item = inflater.inflate(R.layout.movie_item_view, parent, false)

        return ViewHolder(item, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMovie(items[position])
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View, private val itemClick: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.item_text)
        private val imageView: ImageView = view.findViewById(R.id.item_poster)

        fun bindMovie(movie: Movie){
            super.itemView.setOnClickListener({view: View ->
                itemClick.invoke(movie)
            })
            textView.text = movie.title
            Picasso.get().load("$POSTER_BASE${movie.poster_path}").into(imageView)
        }

        companion object {
            private const val POSTER_BASE = "https://image.tmdb.org/t/p/w500/"
        }
    }

}