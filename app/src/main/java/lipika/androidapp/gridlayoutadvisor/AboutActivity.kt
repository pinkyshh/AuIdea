package lipika.androidapp.gridlayoutadvisor

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_home.*

class AboutActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val pre_fragment = PreFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, pre_fragment).commit()

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
