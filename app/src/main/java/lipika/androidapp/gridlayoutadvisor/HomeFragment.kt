package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.AllApi
import api.HomeProject
import api.HomeProjectItem
import kotlinx.android.synthetic.main.activity_recommend.*
import kotlinx.android.synthetic.main.item_container_sp1.view.*
import kotlinx.android.synthetic.main.item_container_sp1.view.color_bar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val REQUEST_CODE=102
private const val REQUEST_CODE1=103

class HomeFragment: Fragment() {

    private var list: HomeProject = HomeProject()
    private lateinit var listAdapter: ProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_home,container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        saveRecyclerView.layoutManager = LinearLayoutManager(activity)
        listAdapter = ProjectAdapter(list)
        saveRecyclerView.adapter = listAdapter

        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://auidea.azurewebsites.net/").addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        val Api: AllApi = retrofit.create(AllApi::class.java)

//        Get Project HomeScreen
        val getProjectRequest: Call<HomeProject> = Api.getHomeProject()
        getProjectRequest.enqueue(object : Callback<HomeProject> {

            override fun onResponse(call: Call<HomeProject>, response: Response<HomeProject>) {
                var projectResponse = response.body()
                if (projectResponse != null) {
                    listAdapter.setData(projectResponse)
                    Log.d("SPARK-API", projectResponse.toString())
                }
            }

            override fun onFailure(call: Call<HomeProject>, t: Throwable) {
                Log.d("SPARK-API", "Failed to Request!")
            }
        })

    }

    private inner class View1Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var p_name: TextView = itemView.findViewById(R.id.nameSP1)
        var g_name: TextView = itemView.findViewById(R.id.grpSP1)
        var sem: TextView = itemView.findViewById(R.id.semSP1)
        var type: TextView = itemView.findViewById(R.id.SP1)

        lateinit var project: HomeProjectItem

        fun bind(project: HomeProjectItem){
            this.project=project
            p_name.text = (project.projectTitle)
            g_name.setText(project.groupName)
            sem.text = (project.semester)
            type.text = ("Senior Project " + project.projectType.toString())
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ProjectDetail::class.java)
                intent.putExtra("p_number", project.projectNo.toString())
                Log.d("SPARK-API","ABCD ${project.projectNo}")
                startActivity(intent)
            }
        }
    }

    private inner class ProjectAdapter(var projects: HomeProject):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        var seniorProject1=1
        var seniorProject2=2

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val View1=layoutInflater.inflate(R.layout.item_container_sp1,parent,false)

            //For Text
            View1.SP1.setTextColor(if (viewType==seniorProject1) resources.getColor(R.color.SP1)
            else
                resources.getColor(R.color.SP2))

            //For color bar
            View1.color_bar.setBackgroundColor(if (viewType==seniorProject1) resources.getColor(R.color.SP1)
            else
                resources.getColor(R.color.SP2))

            return View1Holder(View1)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val project = projects[position]
            (holder as View1Holder).bind(project)
        }

        override fun getItemCount(): Int {
            return projects.size
        }

        override fun getItemViewType(position: Int): Int {
            val project = projects[position]
            return if(project.projectType == 1){
                seniorProject1
            }else{
                seniorProject2
            }
        }

        fun setData(project: HomeProject) {
            projects = project
            notifyDataSetChanged()
        }
    }
}