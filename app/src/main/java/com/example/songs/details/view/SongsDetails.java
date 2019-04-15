package com.example.songs.details.view;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songs.R;
import com.example.songs.details.adapter.ListAdapter;
import com.example.songs.details.model.ListItem;
import com.example.songs.details.presenter.SongsDetailsPresenter;
import com.example.songs.list.model.SongItem;
import com.example.songs.utility.AppManager;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: SongsDetails.java
 * @Module Name: Song Details
 * @Description : SongsDetails class
 * @Author: Akhilesh Dubey
 *
 */

public class SongsDetails extends AppCompatActivity implements SongsDetailsPresenter.View {
    /*--- Define Variable ---*/
    SongsDetailsPresenter songsDetailsPresenter;
    MediaPlayer mPlayer;
    Button mButtonPlay;
    ImageView imgDetails;
    boolean isPlaying = false;
    RecyclerView rvDetails;
    ArrayList<ListItem> listItems;
    ListAdapter listAdapter;

    /*--- Default activity methods---*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_details);

        songsDetailsPresenter = new SongsDetailsPresenter(this, this);
        songsDetailsPresenter.initiate();
    }

    @Override
    protected void onDestroy() {
        songsDetailsPresenter.presenterDestroy();
        super.onDestroy();
    }

    /*--- Initialize data and variable here ---*/
    private void init(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView txtTitle =  (TextView)findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.songsDetail));
        txtTitle.setVisibility(View.VISIBLE);

        isPlaying = false;
        imgDetails = (ImageView)findViewById(R.id.imgDetail);
        mButtonPlay = (Button)findViewById(R.id.btnPlay);
        final SongItem songItem = getIntent().getExtras().getParcelable("songItem");
        //textView.setText(songItem.getSongName());
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    mButtonPlay.setText(getString(R.string.songsDetailPlay));
                    isPlaying = false;
                    mPlayer.stop();
                    mPlayer = null;
                }else{
                    isPlaying = true;
                    playSong(songItem.previewUrl);
                }
            }
        });
        Picasso.with(this).load(songItem.artworkUrl100).error(R.drawable.image).placeholder(R.drawable.image).into(imgDetails);

        ListItem listItem;

        listItems = new ArrayList<>();
        listItem = new ListItem(getString(R.string.songsDetail_ArtistName), songItem.artistName);
        listItems.add(listItem);
        listItem = new ListItem(getString(R.string.songsDetail_CollectionName), songItem.collectionName);
        listItems.add(listItem);
        listItem = new ListItem(getString(R.string.songsDetail_TrackName), songItem.trackName);
        listItems.add(listItem);

        listItem = new ListItem(getString(R.string.songsDetail_ReleaseDate), songItem.releaseDate);
        listItems.add(listItem);
        listItem = new ListItem(getString(R.string.songsDetail_Time), "" + (songItem.trackTimeMillis/ 1000));
        listItems.add(listItem);
        listItem = new ListItem(getString(R.string.songsDetail_Country), songItem.country);
        listItems.add(listItem);

        rvDetails = (RecyclerView)findViewById(R.id.rvDetails);
        listAdapter = new ListAdapter(this, listItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvDetails.setLayoutManager(linearLayoutManager);
        rvDetails.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvDetails.setAdapter(listAdapter);
    }

    /*--- Play songs ---*/
    public void playSong( String audioUrl){
        mButtonPlay.setText(getString(R.string.songsDetailStop));
        // The audio url to play
        //String audioUrl = "http://www.all-birds.com/Sound/western%20bluebird.wav";

        // Initialize a new media player instance
        mPlayer = new MediaPlayer();

        // Set the media player audio stream type
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //Try to play music/audio from url
        try{
            // Set the audio data source
            mPlayer.setDataSource(audioUrl);

                    /*
                        void prepare ()
                            Prepares the player for playback, synchronously. After setting the
                            datasource and the display surface, you need to either call prepare()
                            or prepareAsync(). For files, it is OK to call prepare(), which blocks
                            until MediaPlayer is ready for playback.

                        Throws
                            IllegalStateException : if it is called in an invalid state
                            IOException
                    */
            // Prepare the media player
            mPlayer.prepare();

            // Start playing audio from http url
            mPlayer.start();

            // Inform user for audio streaming
            onShowMessage("Song start playing...");
        }catch (IOException e){
            // Catch the exception
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch (SecurityException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                onShowMessage("Song end...");
                mButtonPlay.setText(getString(R.string.songsDetailPlay));
            }
        });
    }

    /*--- Default presenter methods ---*/
    @Override
    public void onPresenterDestroy() {
        songsDetailsPresenter = null;
    }

    @Override
    public void onInitiate() {
        init();
    }

    @Override
    public void onShowMessage(String message) {
        AppManager.showToast(this, message);
    }
}