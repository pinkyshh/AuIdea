package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_home.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        radioGroup.setOnCheckedChangeListener{group,checkedId ->
            if (checkedId == R.id.pre) {
                pre.setBackgroundColor(R.drawable.unselector_tag_button_post)
                post.setBackgroundColor(R.drawable.border)
                val post_fragment = PostFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, post_fragment).commit()

            } else {
                post.setBackgroundColor(R.drawable.unselector_tag_button_post)
                pre.setBackgroundColor(R.drawable.border)
                val pre_fragment = PreFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, pre_fragment).commit()
            }
        }
    }
}
