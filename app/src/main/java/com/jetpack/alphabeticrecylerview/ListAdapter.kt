package com.jetpack.alphabeticrecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyler_view_list_item.view.*

class ListAdapter(private val list:List<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    RecyclerViewFastScroller.OnPopupTextUpdate
{
    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyler_view_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.text_view.text = list[position]
    }

    override fun getItemCount(): Int =
        list.size

    override fun onChange(position: Int): CharSequence =
        list[position].first().toUpperCase().toString()

}