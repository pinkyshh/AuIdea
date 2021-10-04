package api

import retrofit2.Call
import retrofit2.http.GET

interface AllApi {

//    @GET("project/list?id=1111")
//    fun getAdvisor(): Call<Lipika>
//
//    @GET("advisor/detail")
//    fun getAll():Call<AllAdvisorResponse>

    @GET("api/recommendation/getprojectinfo?projectno=111")
    fun getProject():Call<ProjectResponse>

    @GET("api/Recommendation/GetRecommendProject?studentId=6135102")
    fun getRecommender():Call<RecommendedResponse>

    @GET("api/recommendation/home?studentid=5515257")
    fun getRecommendation():Call<Recommendation>

    @GET("api/recommendation/search")
    fun getHomeProject():Call<HomeProject>
}