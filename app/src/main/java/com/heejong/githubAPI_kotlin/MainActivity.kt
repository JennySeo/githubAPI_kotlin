package com.heejong.githubAPI_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.heejong.githubAPI_kotlin.network.APIClient
import com.heejong.githubAPI_kotlin.network.APIInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    var url: String = "https://api.github.com/"
    var userName = ""
    var mEditText: EditText? = null
    val adapter =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            btnlistner(it)
        }

//        mEditText = findViewById<EditText>(R.id.inputText)
//
//        mEditText.setOnClickListener()



    }
    @SuppressLint("CheckResult")
    private fun btnlistner(view: View) {
        Toast.makeText(this, "btton click ! ", Toast.LENGTH_SHORT).show()
        val returnstr = "JennySeo"//checkInputText(view)
        if (!returnstr.isEmpty()) {
            //start connect
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
                        val nextIntent = Intent(this, GithubApiActivity::class.java)
                        startActivity(nextIntent)
//                    } else {
//                        Log.d("HJHJ", "subscribe bad")
//                    }
//                }

                    } else {
                        Toast.makeText(this, " please enter your USERID", Toast.LENGTH_SHORT).show()
                    }

                }
//    private fun inputUserlistner(view : View){
//
//    }
//    private fun checkInputText(view : View): String {
//        val str ="JennySeo"
//        return str
//    }

        }
    }
}
//private fun EditText.setOnClickListener() {
//    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//}
