package com.heejong.githubAPI_kotlin.network

import com.heejong.githubAPI_kotlin.getGithubInfomation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


internal interface APIInterface {

    @GET("")
    fun getAPIinfo(@Query("url") url: String): Call<getGithubInfomation>
    //?client_id={client_id}&client_secret={client_secret}&search={search}
}
