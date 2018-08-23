package io.github.jetsetpaul.movieskotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by pauljoiner on 8/20/18.
 */

class FiltersListAdapter(val items: List<Filter>, private val itemClick: (Filter) -> Unit): RecyclerView.Adapter<FiltersListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val item = inflater.inflate(R.layout.movie_item_view, parent, false)

        return ViewHolder(item, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFilter(items[position])
    }

    class ViewHolder(view: View, private val itemClick: (Filter) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindFilter(filter: Filter) {
            
        }
    }
}