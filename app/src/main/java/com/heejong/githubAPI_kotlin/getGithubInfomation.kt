package com.heejong.githubAPI_kotlin;
import androidx.appcompat.app.AppCompatActivity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class getGithubInfomation : AppCompatActivity() {
    @SerializedName("id")
    @Expose
    var id : String ? = null

    @SerializedName("avatar_url")
    @Expose
    var avatar_url : String ? = null

    @SerializedName("followers_url")
    @Expose
    var followers_url : String ? = null

    @SerializedName("following_url")
    @Expose
    var following_url : String ?= null

    @SerializedName("starred_url")
    @Expose
    var starred_url : String ? = null

    @SerializedName("type")
    @Expose
    var type : String ? = null

    @SerializedName("name")
    @Expose
    var name : String ? = null

    @SerializedName("company")
    @Expose
    var company : String ? = null

    @SerializedName("location")
    @Expose
    var location : String ? = null

    @SerializedName("email")
    @Expose
    var email : String ? = null

    @SerializedName("public_repos")
    @Expose
    var public_repos : String ? = null


    fun getid(): String? {
        return id
    }

    fun setid(name: String) {
        this.id = name
    }

    fun gettype(): String? {
        return type
    }

    fun setyype(type: String) {
        this.type = type
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String) {
        this.name = name
    }

    fun getcompany(): String? {
        return starred_url
    }

    fun setcompany(company: String) {
        this.company = company
    }

    fun getlocation(): String? {
        return location
    }

    fun setlocation(location: String) {
        this.location = location
    }

    fun getemail(): String? {
        return email
    }

    fun setemail(email: String) {
        this.email = email
    }

    fun getpublic_repos(): String? {
        return public_repos
    }

    fun setpublic_repos(public_repos: String) {
        this.public_repos = public_repos
    }

}
