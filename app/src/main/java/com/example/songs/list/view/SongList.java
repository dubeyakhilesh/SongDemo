package com.example.songs.list.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.songs.list.interfaces.ListCallBack;
import com.example.songs.list.adapter.SongAdapter;
import com.example.songs.list.model.SongItem;
import com.example.songs.list.presenter.ListPresenter;
import com.example.songs.utility.AppManager;
import com.example.songs.R;
import com.example.songs.details.view.SongsDetails;

import java.util.ArrayList;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongList.java
 * @Module Name: Song List
 * @Description : SongList activity class
 * @Author: Akhilesh Dubey
 *
 */

public class SongList extends AppCompatActivity implements ListCallBack, ListPresenter.View {

    /*-- Define Variable --*/
    ListPresenter listPresenter;
    SongAdapter songAdapter;
    RecyclerView rvListSong;
    ArrayList<SongItem> songItems;
    ProgressDialog progressDialog;
    SwipeRefreshLayout srlList;

    /*-- Default activity lifecycle method --*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        listPresenter = new ListPresenter(this, this);
        listPresenter.initiate();
    }

    @Override
    protected void onDestroy() {
        listPresenter.destroy();
        super.onDestroy();
    }

    /*--- Variable and data initialize here ---*/
    private void init(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView txtTitle =  (TextView)findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.songsList));
        txtTitle.setVisibility(View.VISIBLE);

        progressDialog = AppManager.initProgress(this);
        songItems = new ArrayList<>();
        rvListSong = (RecyclerView)findViewById(R.id.rvListSong);
        songAdapter = new SongAdapter(this, songItems, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListSong.setLayoutManager(linearLayoutManager);
        //rvListSong.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvListSong.setAdapter(songAdapter);
        srlList = (SwipeRefreshLayout)findViewById(R.id.srlList);
        srlList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listPresenter.fetchSongsData();
            }
        });

        listPresenter.fetchSongsData();
    }

    /*--- Call back ---*/
    @Override
    public void listCallBack(int type, int position) {
        Intent intent = new Intent(this, SongsDetails.class);
        intent.putExtra("songItem", songItems.get(position));
        startActivity(intent);
    }

    /*--- Presenter call back methods ---*/
    @Override
    public void onPresenterDestroy() {
        listPresenter = null;
    }

    @Override
    public void onInitiate() {
        init();
    }

    @Override
    public void onFtechListData(ArrayList<SongItem> songItem) {
        if(srlList != null && srlList.isRefreshing())
            srlList.setRefreshing(false);
        songItems.clear();
        songItems.addAll(songItem);
        songAdapter.notifyDataSetChanged();
    }

    @Override
    public void onShowProgressBar() {
        if(progressDialog != null)
            progressDialog.show();
    }

    @Override
    public void onHideProgressBar() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onShowMessage(String message) {
        AppManager.showToast(this, message);
    }
}
