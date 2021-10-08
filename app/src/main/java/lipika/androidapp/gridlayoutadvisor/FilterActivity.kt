package lipika.androidapp.gridlayoutadvisor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FilterActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val top_fragment=TopFragment()
        supportFragmentManager.beginTransaction().replace(R.id.topContainerView, top_fragment).commit()
    }
}