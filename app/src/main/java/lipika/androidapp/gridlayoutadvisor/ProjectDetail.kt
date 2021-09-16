package lipika.androidapp.gridlayoutadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.advisor_information.*
import kotlinx.android.synthetic.main.project_detail.*

class ProjectDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.project_detail)

        val project_detail=ProjectDesFragment()
        description.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, project_detail).commit()
            description.setTextColor(resources.getColor(R.color.menuColor))
            team.setTextColor(resources.getColor(R.color.colorPrimaryLight))
        }

        val project_team=ProjectTeamFragment()
        team.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,project_team).commit()
            team.setTextColor(resources.getColor(R.color.menuColor))
            description.setTextColor(resources.getColor(R.color.colorPrimaryLight))
        }

    }
}