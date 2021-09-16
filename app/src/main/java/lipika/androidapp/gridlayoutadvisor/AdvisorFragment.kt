package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.advisor_grid.*
import kotlinx.android.synthetic.main.advisor_information.*

private const val REQUESTCODE=101

class AdvisorFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.advisor_recyclerview, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val advisors=advisorList()
        recyclerView.adapter=RecyclerViewAdapter(advisors)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
    }

    private fun advisorList() : ArrayList<advisor> {
        val advisor=ArrayList<advisor>()
        advisor.add(advisor(R.drawable.dobri, "Dr. Dobri Atanassov Batovski", "Asst Prof"))
        advisor.add(advisor(R.drawable.tap, "Tapanan Yeophantong", "Asst Prof"))
        advisor.add(advisor(R.drawable.anil, "Dr.Anil Kumar GopalKrishna G", "Asst Prof"))
        advisor.add(advisor(R.drawable.paitoon, "Paitoon Porntakroon", "Asst Prof"))
        advisor.add(advisor(R.drawable.rachsuda, "Rachsuda Sethawong", "Asst Prof"))
        advisor.add(advisor(R.drawable.darun, "Darun Kesarat", "Asst Prof"))
        advisor.add(advisor(R.drawable.songsak, "Dr. Songsak Channarukul", "Asst Prof"))
        advisor.add(advisor(R.drawable.kwan, "Dr. Kwan Nongpong", "Asst Prof"))
        advisor.add(advisor(R.drawable.chayapol, "Chayapol Moemeng", "Asst Prof"))
        advisor.add(advisor(R.drawable.thanachai, "Dr. Thanachai Thumthawatworn", "Asst prof"))

        return advisor
    }


    private inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        var image: ImageView =itemView.findViewById(R.id.imageView)
        var name: TextView =itemView.findViewById(R.id.advisorName)
        var professor: TextView =itemView.findViewById((R.id.advisorDescription))

        lateinit var advisor: advisor

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(advisor: advisor) {
            this.advisor=advisor
            image.setImageResource(advisor.img)
            name.text=(advisor.name)
            professor.text=(advisor.professor)
        }

        override fun onClick(v: View?) {
            viewAdvisorButtonGrid.setOnClickListener{

                val intent= Intent(v!!.context,SecondActivity::class.java)
                intent.putExtra("image",advisor.img)
                intent.putExtra("name",advisor.name)
                intent.putExtra("professor",advisor.professor)

                startActivityForResult(intent, REQUESTCODE)
            }


        }

    }

    private inner class RecyclerViewAdapter(var advisors: ArrayList<advisor>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view=layoutInflater.inflate(R.layout.advisor_grid,parent,false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val advisor = advisors[position]
            (holder as ViewHolder).bind(advisor)
        }

        override fun getItemCount(): Int {
            return advisors.size
        }

    }
}