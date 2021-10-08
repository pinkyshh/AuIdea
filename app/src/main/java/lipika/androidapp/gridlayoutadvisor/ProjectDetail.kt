package lipika.androidapp.gridlayoutadvisor

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import api.AllApi
import api.HomeProject
import api.ProjectResponse
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.advisor_information.*
import kotlinx.android.synthetic.main.project_detail.*
import kotlinx.android.synthetic.main.project_detail.color_bar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project_detail)

        var title = intent.getStringExtra("TITLE")
        var name = intent.getStringExtra("GRP")
        var semes = intent.getStringExtra("SEM")
        var type = intent.getStringExtra("TYPE")

        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://auidea.azurewebsites.net/").addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        val Api: AllApi = retrofit.create(AllApi::class.java)
        val projectNumber = intent.getStringExtra("p_number")

        if (projectNumber == "1") {
            color_bar.setTextColor(resources.getColor(R.color.SP1))
        } else if (projectNumber == "2") {
            resources.getColor(R.color.SP2)
        }

//        Get Project Detail
        val getProjectRequest: Call<ProjectResponse> = Api.getProject(projectNumber.toString())
        getProjectRequest.enqueue(object : Callback<ProjectResponse> {

            override fun onResponse(call: Call<ProjectResponse>, response: Response<ProjectResponse>) {
                var projectResponse = response.body()
                Log.d("SPARK-API", response.message())
                Log.d("SPARK-API", projectNumber.toString())


                if (projectResponse != null) {
                    spType.text = "Senior Project " + projectResponse[0].projectType.toString()
                    type = projectResponse[0].projectType.toString()
                    grpName.text = projectResponse[0].groupName
                    name = projectResponse[0].groupName
                    projName.text = projectResponse[0].projectTitle
                    title = projectResponse[0].projectTitle
                    Log.d("SPARK-API", projectResponse.toString())

                }
            }

            override fun onFailure(call: Call<ProjectResponse>, t: Throwable) {
                Log.d("SPARK-API", "Failed to Request!")
            }


        })
        val project = arrayOf(title,name,semes,type)
        savedProj.setOnClickListener{
            val intent2 = Intent()
            intent2.putExtra("SAVED", project)
            setResult(Activity.RESULT_OK,intent2)
        }

        radio.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.description) {
                val project_detail = ProjectDesFragment.newInstance(projectNumber.toString())
                description.setOnClickListener {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, project_detail).commit()
                    description.setTextColor(resources.getColor(R.color.menuColor))
                    team.setTextColor(resources.getColor(R.color.colorPrimaryLight))
                }

            } else {

                val project_team = ProjectTeamFragment.newInstance(projectNumber.toString())
                team.setOnClickListener {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, project_team).commit()
                    team.setTextColor(resources.getColor(R.color.menuColor))
                    description.setTextColor(resources.getColor(R.color.colorPrimaryLight))
                }
            }
        }
    }
}