package com.example.songs.networkHandler;

import com.example.songs.list.model.SongsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: ApiInterface
 * @Module Name: Retrofit
 * @Description : ApiInterface
 * @Author: Akhilesh Dubey
 *
 */
public interface ApiInterface {
    /*-- Fetch Song--*/
    @GET("search?term=Michael+jackson")
    Call<SongsResponse> getSongList();

}


