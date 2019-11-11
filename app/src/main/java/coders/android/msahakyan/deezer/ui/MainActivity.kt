package coders.android.msahakyan.deezer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import coders.android.msahakyan.deezer.R
import kotlinx.android.synthetic.main.activity_main.bottom_navigation_view

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        // Set up navigation menu
        bottom_navigation_view.setupWithNavController(navController)
    }
}
