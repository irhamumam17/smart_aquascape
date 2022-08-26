package com.example.smart_aquascape.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smart_aquascape.R
import com.example.smart_aquascape.data.model.MonitoringData

class DataAdapter(private val listDataArrayList: List<MonitoringData>): RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNo: TextView
        val tvDate: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvNo = view.findViewById(R.id.txtNo)
            tvDate = view.findViewById(R.id.txtDate)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvNo.text = listDataArrayList[position].id.toString()
        viewHolder.tvDate.text = listDataArrayList[position].date
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = listDataArrayList.size
}