package com.heejong.githubAPI_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.heejong.githubAPI_kotlin.network.APIClient
import com.heejong.githubAPI_kotlin.network.APIInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var inputUser: EditText = findViewById(R.id.inputText)
    var url = "https://api.github.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{ btnlistner() }

        inputUser.setOnClickListener{ inputUserlistner() }

    }
    private fun btnlistner(){
        Toast.makeText(this, "btton click ! ",Toast.LENGTH_SHORT).show()
        val returnstr = checkInputText()
        if(!returnstr.isEmpty()) {
            //start connect
            val adapter = APIClient.getInstance()
            adapter.requestContributors(returnstr)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError {
                    Toast.makeText(this, "doOnError", Toast.LENGTH_SHORT).show()
                    Log.d("HJHJ", "doOnError")
                }
                .unsubscribeOn(Schedulers.io())
                .onErrorReturn { t: Throwable ->
                    Log.d("HJHJ", "onErrorReturn : " + t.message)
                    arrayOf(getGithubInfomation())
                }
                .subscribe { result ->
                    if ("User" == result[0].gettype()) { // NULL이 안옴
                        Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                        Log.d("HJHJ", "subscribe good")
                    } else {
                        Log.d("HJHJ", "subscribe bad")
                    }
                }

        }else {
            Toast.makeText(this, " please enter your USERID", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputUserlistner(){

    }
    private fun checkInputText(): String {
        val str =inputUser.text.toString()
        return str
    }

}
