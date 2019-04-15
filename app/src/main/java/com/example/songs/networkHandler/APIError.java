package com.example.songs.networkHandler;


/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: APIError.java
 * @Module Name: Retrofit
 * @Description : base APIError networking class
 * @Author: Akhilesh Dubey
 *
 */

public class APIError {
    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
