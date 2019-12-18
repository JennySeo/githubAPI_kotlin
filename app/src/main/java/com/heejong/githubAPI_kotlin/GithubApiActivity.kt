package com.heejong.githubAPI_kotlin

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.ImageView
import android.widget.Toast
import com.heejong.githubAPI_kotlin.network.APIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.nav_header_github_api.*


class GithubApiActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_githubapi)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
//        val image : ImageView = findViewById(R.id.imageView2)
//        val imageBitmap : Bitmap
//        imageBitmap = BitmapFactory.decodeStream(getGithubInfomation.);
//        imageView.setImageBitmap(imageBitmap);
        // Passing each menu ID as a set of Ids  because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val adapter = APIClient.getInstance()
        adapter.requestContributors("JennySeo")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Toast.makeText(this, "doOnError", Toast.LENGTH_SHORT).show()
                Log.d("HJHJ", "doOnError")
            }
            .unsubscribeOn(Schedulers.io())
//                .onErrorReturn { t: Throwable ->
//                    Log.d("HJHJ", "onErrorReturn : " + t.message)
////                    getGithubInfomation()
//                }
            .subscribe { result ->
                if (result.getid()!=null) {// NULL이 안옴
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                    Log.d("HJHJ", "subscribe good")
                    Log.d("HJHJ", "getcompany : " +result.getcompany())
                    Log.d("HJHJ", "gettype : " +result.gettype())
                    Log.d("HJHJ", "getlocation : " +result.getlocation())
                    Log.d("HJHJ", "getType : " +result.gettype())
                    Log.d("HJHJ", "getpublic_repos : " +result.getpublic_repos())
                    Log.d("HJHJ", "get_following : " +result.get_following())
                    val company = result.getcompany()
                    if (company != null) {
                        result.setcompany(company)
                    }

//                    } else {
//                        Log.d("HJHJ", "subscribe bad")
//                    }
//                }
                    toolbar.title = result.getlogin()
                } else {
                    Toast.makeText(this, " please enter your USERID", Toast.LENGTH_SHORT).show()
                }

            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.github_api, menu)
        val apply = menuInflater.apply { }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
