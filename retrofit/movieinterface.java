package com.example.iraq.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iraq on 3/5/2018.
 */

public interface movieinterface {
    @GET("/") //for get movie request
    Call<MovieModel> getmovie(@Query("i") String movieid,@Query("apiKey") String key);

}
