package com.example.songs.list.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongItem.java
 * @Module Name: Song List
 * @Description : SongItem model class
 * @Author: Akhilesh Dubey
 *
 */

public class SongItem implements Parcelable {
    @SerializedName("wrapperType")
    @Expose
    public String wrapperType;

    @SerializedName("kind")
    @Expose
    public String kind;

    @SerializedName("artistId")
    @Expose
    public int artistId;

    @SerializedName("collectionId")
    @Expose
    public int collectionId;

    @SerializedName("trackId")
    @Expose
    public int trackId;

    @SerializedName("artistName")
    @Expose
    public String artistName;

    @SerializedName("collectionName")
    @Expose
    public String collectionName;

    @SerializedName("trackName")
    @Expose
    public String trackName;

    @SerializedName("collectionCensoredName")
    @Expose
    public String collectionCensoredName;

    @SerializedName("trackCensoredName")
    @Expose
    public String trackCensoredName;

    @SerializedName("artistViewUrl")
    @Expose
    public String artistViewUrl;

    @SerializedName("collectionViewUrl")
    @Expose
    public String collectionViewUrl;

    @SerializedName("trackViewUrl")
    @Expose
    public String trackViewUrl;

    @SerializedName("previewUrl")
    @Expose
    public String previewUrl;

    @SerializedName("artworkUrl30")
    @Expose
    public String artworkUrl30;

    @SerializedName("artworkUrl60")
    @Expose
    public String artworkUrl60;

    @SerializedName("artworkUrl100")
    @Expose
    public String artworkUrl100;

    @SerializedName("collectionPrice")
    @Expose
    public double collectionPrice;

    @SerializedName("trackPrice")
    @Expose
    public double trackPrice;

    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;

    @SerializedName("collectionExplicitness")
    @Expose
    public String collectionExplicitness;

    @SerializedName("trackExplicitness")
    @Expose
    public String trackExplicitness;

    @SerializedName("discCount")
    @Expose
    public int discCount;

    @SerializedName("discNumber")
    @Expose
    public int discNumber;

    @SerializedName("trackCount")
    @Expose
    public int trackCount;

    @SerializedName("trackNumber")
    @Expose
    public int trackNumber;

    @SerializedName("trackTimeMillis")
    @Expose
    public int trackTimeMillis;

    @SerializedName("country")
    @Expose
    public String country;

    @SerializedName("currency")
    @Expose
    public String currency;

    @SerializedName("primaryGenreName")
    @Expose
    public String primaryGenreName;

    @SerializedName("isStreamable")
    @Expose
    public boolean isStreamable;

    protected SongItem(Parcel in) {
        wrapperType = in.readString();
        kind = in.readString();
        artistId = in.readInt();
        collectionId = in.readInt();
        trackId = in.readInt();
        artistName = in.readString();
        collectionName = in.readString();
        trackName = in.readString();
        collectionCensoredName = in.readString();
        trackCensoredName = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        trackViewUrl = in.readString();
        previewUrl = in.readString();
        artworkUrl30 = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl100 = in.readString();
        collectionPrice = in.readDouble();
        trackPrice = in.readDouble();
        releaseDate = in.readString();
        collectionExplicitness = in.readString();
        trackExplicitness = in.readString();
        discCount = in.readInt();
        discNumber = in.readInt();
        trackCount = in.readInt();
        trackNumber = in.readInt();
        trackTimeMillis = in.readInt();
        country = in.readString();
        currency = in.readString();
        primaryGenreName = in.readString();
        isStreamable = in.readByte() != 0;
    }

    public static final Creator<SongItem> CREATOR = new Creator<SongItem>() {
        @Override
        public SongItem createFromParcel(Parcel in) {
            return new SongItem(in);
        }

        @Override
        public SongItem[] newArray(int size) {
            return new SongItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wrapperType);
        dest.writeString(kind);
        dest.writeInt(artistId);
        dest.writeInt(collectionId);
        dest.writeInt(trackId);
        dest.writeString(artistName);
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(collectionCensoredName);
        dest.writeString(trackCensoredName);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(trackViewUrl);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl30);
        dest.writeString(artworkUrl60);
        dest.writeString(artworkUrl100);
        dest.writeDouble(collectionPrice);
        dest.writeDouble(trackPrice);
        dest.writeString(releaseDate);
        dest.writeString(collectionExplicitness);
        dest.writeString(trackExplicitness);
        dest.writeInt(discCount);
        dest.writeInt(discNumber);
        dest.writeInt(trackCount);
        dest.writeInt(trackNumber);
        dest.writeInt(trackTimeMillis);
        dest.writeString(country);
        dest.writeString(currency);
        dest.writeString(primaryGenreName);
        dest.writeByte((byte) (isStreamable ? 1 : 0));
    }
}
