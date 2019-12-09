package com.heejong.githubAPI_kotlin.network

import com.heejong.githubAPI_kotlin.getGithubInfomation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import io.reactivex.Single


internal interface APIInterface {
    @GET("users/{username}")
    fun requestContributors(
        @Path("username") userName:String
        ) : Single<getGithubInfomation>

}