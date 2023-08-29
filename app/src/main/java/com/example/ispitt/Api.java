package com.example.ispitt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "http://novilekar-001-site1.dtempurl.com/";
   //String BASE_URL ="http://192.168.1.22:83/";
    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("getJobs")
    Call<List<Job>> getJobs();


    @GET("getJobsOfHero/{id}")
    Call<List<Job>> getJobsOfHero(@Path("id") int id);


    @GET("getJob/")
    Call<Job> getJob();
    @POST("registerHero")
    Call<Hero> registerHero(@Body Hero hero);


    @POST("loginHero")
    Call<Hero> loginHero(@Query("username") String username, @Query("password") String password);


    @DELETE("deleteHero/{id}")
    Call <Void>deleteHero();






}