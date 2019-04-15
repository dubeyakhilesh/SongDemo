package com.example.songs.list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.songs.R;
import com.example.songs.list.interfaces.ListCallBack;
import com.example.songs.list.model.SongItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongAdapter.java
 * @Module Name: Song List
 * @Description : SongAdapter class
 * @Author: Akhilesh Dubey
 *
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MySongItem> {
    /*--- Define variables here ---*/
    Context context;
    ArrayList<SongItem> songItems;
    ListCallBack listCallBack;

    /*--- Initialize constructor here ---*/
    public SongAdapter(Context context, ArrayList<SongItem> songItems, ListCallBack listCallBack){
        this.context = context;
        this.songItems = songItems;
        this.listCallBack = listCallBack;
    }

    /*--- Default Adapter methods ---*/
    @NonNull
    @Override
    public MySongItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_list_item, viewGroup, false);
        MySongItem mySongItem = new MySongItem(view);
        return mySongItem;
    }

    @Override
    public void onBindViewHolder(@NonNull MySongItem mySongItem, int i) {
        SongItem songItem = songItems.get(i);
        mySongItem.txtName.setText(songItem.trackName);
        mySongItem.txtType.setText(songItem.trackCensoredName);
        Picasso.with(context).load(songItem.artworkUrl100).error(R.drawable.image).placeholder(R.drawable.image).into(mySongItem.imgList);
    }

    @Override
    public int getItemCount() {
        return songItems.size();
    }

    /*--- view holder class ---*/
    class MySongItem extends RecyclerView.ViewHolder{
        TextView txtName, txtType;
        RelativeLayout rlParent;
        ImageView imgList;
        public MySongItem(@NonNull View itemView) {
            super(itemView);
            imgList = (ImageView)itemView.findViewById(R.id.imgList);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtType = (TextView)itemView.findViewById(R.id.txtType);
            rlParent = (RelativeLayout)itemView.findViewById(R.id.rlParent);
            rlParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listCallBack != null)
                        listCallBack.listCallBack(0, getAdapterPosition());
                }
            });
        }
    }
}
