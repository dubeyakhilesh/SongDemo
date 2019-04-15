package com.example.songs.list.presenter;

import android.content.Context;

import com.example.songs.R;
import com.example.songs.list.model.SongItem;
import com.example.songs.list.model.SongsResponse;
import com.example.songs.networkHandler.ApiClient;
import com.example.songs.networkHandler.ApiError;
import com.example.songs.networkHandler.ApiInterface;
import com.example.songs.utility.AppManager;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: ListPresenter.java
 * @Module Name: Song List
 * @Description : ListPresenter class
 * @Author: Akhilesh Dubey
 *
 */

public class ListPresenter {
    /*--- Define Variable ---*/
    Context context;
    View view;

    /*--- Initialize constructor here ---*/
    public ListPresenter(Context context, View view){
        this.context = context;
        this.view = view;
    }

    /*--- Presenter methods ---*/
    public void destroy() {
        view.onPresenterDestroy();
    }

    public void initiate() {
        view.onInitiate();
    }


    public void fechListData(ArrayList<SongItem> songItems) {
        view.onFtechListData(songItems);
    }

    public void showProgressBar() {
        view.onShowProgressBar();
    }

    public void hideProgressBar() {
        view.onHideProgressBar();
    }

    public void showMessage(String message){
        view.onShowMessage(message);
    }

    /*--fetch Songs Data--*/
    public void fetchSongsData() {

        if (!AppManager.isConnectingToInternet(context)) {
            showMessage(context.getString(R.string.error_noInternet));
            return;
        }

        ApiInterface apiService =
                ApiClient.getUserClient().create(ApiInterface.class);

        Call<SongsResponse> call = null;
        try {
            call = apiService.getSongList();
        }catch (Exception exception){
            showMessage(context.getString(R.string.error_serverError));
        }

        if(call != null) {
            //show progress dialog
            showProgressBar();
            call.enqueue(new Callback<SongsResponse>() {
                @Override
                public void onResponse(Call<SongsResponse> call, Response<SongsResponse> response) {
                    //hide progress dialog
                    hideProgressBar();
                    int code = response.code();
                    if (code == 200) {

                        fechListData(response.body().getSongItems());
                    } else {
                        try {
                            Gson gson = new Gson();
                            ApiError apiError = gson.fromJson(response.errorBody().charStream(), ApiError.class);
                            String msg = apiError.getErrorMessage();
                            if(AppManager.isValidString(msg))
                                showMessage(msg);
                        } catch (Exception ex) {
                            showMessage(context.getString(R.string.error_serverError));
                        }
                    }
                }

                @Override
                public void onFailure(Call<SongsResponse> call, Throwable t) {
                    //hide progress dialog
                    hideProgressBar();
                    showMessage(context.getString(R.string.error_serverError));
                }
            });
        }
    }

    /*--- Define Interface ---*/
    public interface View{

        void onPresenterDestroy();
        void onInitiate();
        void onFtechListData(ArrayList<SongItem> songItems);
        void onShowProgressBar();
        void onHideProgressBar();
        void onShowMessage(String message);

    }
}
