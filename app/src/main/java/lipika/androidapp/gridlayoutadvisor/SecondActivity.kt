package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.advisor_information.*
import kotlinx.android.synthetic.main.project_detail.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.advisor_information)

        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")

        advisorNameInfo.text = name
        Picasso.get().load(image).into(imageAdvisor)

        advisorRadio.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.specButton) {

                val specialty_fragment = specialRecyclerFragment()
                specButton.setOnClickListener {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewAdvisor, specialty_fragment).commit()
                    specButton.setTextColor(resources.getColor(R.color.menuColor))
                    projButton.setTextColor(resources.getColor(R.color.colorPrimaryLight))
                }

            } else {

                val project_fragment = ProjectFragment()
                projButton.setOnClickListener {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerViewAdvisor, project_fragment).commit()
                    projButton.setTextColor(resources.getColor(R.color.menuColor))
                    specButton.setTextColor(resources.getColor(R.color.colorPrimaryLight))
                }
            }
        }
    }
}