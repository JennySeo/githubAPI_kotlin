package com.heejong.githubAPI_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.heejong.githubAPI_kotlin.network.APIClient
import com.heejong.githubAPI_kotlin.network.APIInterface

class MainActivity : AppCompatActivity() {
    var inputUser: EditText = findViewById(R.id.inputText)
    var url = "https://api.github.com/users/"
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
            url = url+returnstr
            Log.e("HJHJ", "url :"+url)
//            APIClient.getClient(url).
            //start next activity

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
