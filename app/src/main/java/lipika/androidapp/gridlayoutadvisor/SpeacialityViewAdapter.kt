package lipika.androidapp.gridlayoutadvisor

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SpeacialityViewAdapter(context:Context, list: ArrayList<specialty>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val context:Context=context
    var list: ArrayList<specialty> = list

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var spec: TextView =itemView.findViewById(R.id.special)

        fun bind(position: Int) {
            val recyclerViewModel=list[position]
            spec.text=(recyclerViewModel.speciality)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.specialty, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }




}

