package lipika.androidapp.gridlayoutadvisor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectViewAdapter (context: Context, list: ArrayList<Project>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context : Context = context
    var list: ArrayList<Project> = list

    private inner class View1Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var p_name: TextView = itemView.findViewById(R.id.nameSP1)
        var g_name: TextView = itemView.findViewById(R.id.grpSP1)
        var sem: TextView = itemView.findViewById(R.id.semSP1)
        var type: TextView = itemView.findViewById(R.id.SP1)


        fun bind(position: Int){
            val recyclerViewModel = list[position]
            p_name.text = (recyclerViewModel.project_name)
            g_name.setText(recyclerViewModel.group_name)
            sem.text = (recyclerViewModel.semester)
            type.text = (recyclerViewModel.project_no)
        }
    }

    private inner class View2Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var p_name: TextView = itemView.findViewById(R.id.nameSP2)
        var g_name: TextView = itemView.findViewById(R.id.grpSP2)
        var sem: TextView = itemView.findViewById(R.id.semSP2)
        var type: TextView = itemView.findViewById(R.id.SP2)
        fun bind(position: Int){
            val recyclerViewModel = list[position]
            p_name.text = (recyclerViewModel.project_name)
            g_name.setText(recyclerViewModel.group_name)
            sem.text = (recyclerViewModel.semester)
            type.text = (recyclerViewModel.project_no)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == VIEW_TYPE_ONE) {
            return View1Holder(
                LayoutInflater.from(context).inflate(R.layout.item_container_sp1, parent, false)
            )
        }
        return View2Holder(
            LayoutInflater.from(context).inflate(R.layout.item_container_sp2, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(list[position].viewType == 1){
            (holder as View1Holder).bind(position)
        }else{
            (holder as View2Holder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(list[position].viewType == 1){
            VIEW_TYPE_ONE
        }else{
            VIEW_TYPE_TWO
        }
    }
}