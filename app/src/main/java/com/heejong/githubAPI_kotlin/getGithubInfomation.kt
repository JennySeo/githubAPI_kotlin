package com.heejong.githubAPI_kotlin;


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class getGithubInfomation {


    @SerializedName("login")

    @Expose
    var id : String ? = null
    @SerializedName("id")


    @Expose
    var node_id : String ? = null
    @SerializedName("node_id")

    @Expose
    var avatar_url : String ? = null
    @SerializedName("avatar_url")

    @Expose
    var gravatar_id : String ? = null
    @SerializedName("gravatar_id")

    @Expose
    var url : String ? = null
    @SerializedName("url")

    @Expose
    var html_url : String ? = null
    @SerializedName("html_url")


    @Expose
    var followers_url : String ? = null
    @SerializedName("followers_url")


    @Expose
    var following_url : String ?= null
    @SerializedName("following_url")

    @Expose
    var gists_url : String ?= null
    @SerializedName("gists_url")


    @Expose
    var starred_url : String ? = null
    @SerializedName("starred_url")

    @Expose
    var subscriptions_url : String ?= null
    @SerializedName("subscriptions_url")

    @Expose
    var organizations_url : String ?= null
    @SerializedName("organizations_url")

    @Expose
    var repos_url : String ?= null
    @SerializedName("repos_url")

    @Expose
    var events_url : String ?= null
    @SerializedName("events_url")

    @Expose
    var received_events_url : String ?= null
    @SerializedName("received_events_url")



    @Expose
    var type : String ? = null
    @SerializedName("type")


    @Expose
    var site_admin : String ?= null
    @SerializedName("site_admin")



    @Expose
    var name : String ? = null
    @SerializedName("name")


    @Expose
    var company : String ? = null
    @SerializedName("company")


    @Expose
    var blog : String ?= null
    @SerializedName("blog")

    @Expose
    var location : String ? = null
    @SerializedName("location")


    @Expose
    var email : String ? = null
    @SerializedName("email")


    @Expose
    var hireable : String ? = null
    @SerializedName("hireable")


    @Expose
    var bio : String ? = null
    @SerializedName("bio")

    @Expose
    var public_repos : Int ? = null
    @SerializedName("public_repos")

    @Expose
    var public_gists : String ? = null
    @SerializedName("public_gists")

    @Expose
    var followers : String ? = null
    @SerializedName("followers")

    @Expose
    var following : Int ? = null
    @SerializedName("following")

    @Expose
    var created_at : String ? = null
    @SerializedName("created_at")

    @Expose
    var updated_at : String ? = null
    @SerializedName("updated_at")



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

    fun getpublic_repos(): Int? {
        return public_repos
    }

    fun setpublic_repos(public_repos: Int) {
        this.public_repos = public_repos
    }
    fun get_following(): Int? {
        return following
    }

    fun set_following(following: Int) {
        this.following = following
    }

    fun get_avatar_url() : String? {
        return avatar_url
    }
    fun set_avatar_url(avatar_url: String) {
        this.avatar_url = avatar_url
    }
}
