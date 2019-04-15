package com.example.songs.details.presenter;

import android.content.Context;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongsDetailsPresenter.java
 * @Module Name: Song Details
 * @Description : SongsDetailsPresenter class
 * @Author: Akhilesh Dubey
 *
 */

public class SongsDetailsPresenter {
    /*--- Define variables here ---*/
    Context context;
    View view;

    /*--- Initialize Constructor here ---*/
    public SongsDetailsPresenter(Context context, View view){
        this.context = context;
        this.view = view;
    }

    /*--- Song Details Presenter method ---*/
    public void presenterDestroy(){
        view.onPresenterDestroy();
    }

    public void initiate(){
        view.onInitiate();
    }

    void showMessage(String message){
        view.onShowMessage(message);
    }

    /*--- Define Interface ---*/
    public interface View{
        void onPresenterDestroy();
        void onInitiate();
        void onShowMessage(String message);
    }
}
