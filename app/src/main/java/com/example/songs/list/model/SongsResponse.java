package com.example.songs.list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongsResponse.java
 * @Module Name: Song List
 * @Description : SongsResponse class
 * @Author: Akhilesh Dubey
 *
 */

public class SongsResponse {
    @SerializedName("resultCount")
    @Expose
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @SerializedName("results")
    @Expose
    private ArrayList<SongItem> songItems;

    public ArrayList<SongItem> getSongItems() {
        return songItems;
    }

    public void setSongItems(ArrayList<SongItem> songItems) {
        this.songItems = songItems;
    }
}
