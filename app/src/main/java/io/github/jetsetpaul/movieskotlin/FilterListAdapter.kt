package io.github.jetsetpaul.movieskotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by pauljoiner on 8/20/18.
 */

class FilterListAdapter(val items: List<Filter>, private val itemClick: (Filter) -> Unit): RecyclerView.Adapter<FilterListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val item = inflater.inflate(R.layout.filter_item_view, parent, false)

        return ViewHolder(item, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFilter(items[position])
    }

    class ViewHolder(view: View, private val itemClick: (Filter) -> Unit) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.filter_text)
        fun bindFilter(filter: Filter) {
            super.itemView.setOnClickListener({view: View ->
                itemClick.invoke(filter)
            })
            textView.text = filter.category
        }
    }
}