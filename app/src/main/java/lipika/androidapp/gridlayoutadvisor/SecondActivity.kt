package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.advisor_information.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.advisor_information)

        val specialty_fragment = specialRecyclerFragment()
        specButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewAdvisor, specialty_fragment).commit()
            specButton.setTextColor(resources.getColor(R.color.colorPrimaryLight))
            projButton.setTextColor(resources.getColor(R.color.menuColor))
        }

        val project_fragment=ProjectFragment()
        projButton.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerViewAdvisor, project_fragment).commit()
            projButton.setTextColor(resources.getColor(R.color.colorPrimaryLight))
            specButton.setTextColor(resources.getColor(R.color.menuColor))
        }

    }
}