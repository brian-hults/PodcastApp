package com.example.hults.podcastapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class NowPlayingActivity extends AppCompatActivity {
    String episodeClass = "";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        // Pulls the episode information passed on by the Click Listener
        Bundle episodeInfo = getIntent().getExtras();
        String episodeTitle = episodeInfo.getString("Title");
        String releaseDate = episodeInfo.getString("Release Date");
        String description = episodeInfo.getString("Description");
        int podcastImg  = episodeInfo.getInt("ImgViewID");
        episodeClass = episodeInfo.getString("Caller");

        // Finds the Episode title TextView and inserts the current episode info
        TextView nowPlayingTitle = (TextView) findViewById(R.id.episode_title_now_playing);
        nowPlayingTitle.setText(episodeTitle);

        // Sets up description field
        String fullDescription = releaseDate + " - " + description;
        // Finds the Episode details TextView and inserts the combined release date and description
        TextView episodeDetails = (TextView) findViewById(R.id.episode_details);
        episodeDetails.setText(fullDescription);

        // Finds the Podcast ImageView and inputs the Img tag
        ImageView nowPlayingImg = (ImageView) findViewById(R.id.episode_img_now_playing);
        nowPlayingImg.setImageResource(podcastImg);
    }
}
