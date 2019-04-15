package com.example.songs.details.model;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: ListItem.java
 * @Module Name: Song Details
 * @Description : ListItem model class
 * @Author: Akhilesh Dubey
 *
 */

public class ListItem {
    /*--- Define Variable ---*/
    private String header, value;

    /*--- Initialize Constructor ---*/
    public ListItem(String header, String value){
        this.header = header;
        this.value = value;
    }

    /*--- Getter Setter method of class ---*/
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
