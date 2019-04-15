package com.example.songs.details.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.songs.R;
import com.example.songs.details.model.ListItem;

import java.util.ArrayList;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: ListAdapter.java
 * @Module Name: Song Detail
 * @Description : ListAdapter class
 * @Author: Akhilesh Dubey
 *
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyItem> {
    /*--- Define Variable here ---*/
    Context context;
    ArrayList<ListItem> listItems;

    /*--- Define list constructor ---*/
    public ListAdapter(Context context, ArrayList<ListItem> listItems){
        this.context = context;
        this.listItems = listItems;
    }

    /*--- DefaultAdaptar methods ---*/
    @NonNull
    @Override
    public MyItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        MyItem myItem = new MyItem(view);
        return myItem;
    }

    @Override
    public void onBindViewHolder(@NonNull MyItem myItem, int i) {
        ListItem listItem = listItems.get(i);
        myItem.txtHeader.setText(listItem.getHeader());
        myItem.txtValue.setText(" " + listItem.getValue());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    /*--- View holder class ---*/
    class MyItem extends RecyclerView.ViewHolder{
        TextView txtHeader, txtValue;
        public MyItem(@NonNull View itemView) {
            super(itemView);
            txtHeader = (TextView)itemView.findViewById(R.id.txtHeader);
            txtValue = (TextView)itemView.findViewById(R.id.txtValue);

        }
    }
}
