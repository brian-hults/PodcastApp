package com.example.hults.podcastapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the daily news category
        TextView dailyNews = (TextView) findViewById(R.id.podcast_daily_news);
        // Set a click listener on that View
        dailyNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dailyIntent = new Intent(MainActivity.this, DailyNewsActivity.class);
                startActivity(dailyIntent);
            }
        });

        // Find the View that shows the history category
        TextView history = (TextView) findViewById(R.id.podcast_history);
        // Set a click listener on that View
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });

        // Find the View that shows the STEM category
        TextView stem = (TextView) findViewById(R.id.podcast_stem);
        // Set a click listener on that View
        stem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stemIntent = new Intent(MainActivity.this, StemActivity.class);
                startActivity(stemIntent);
            }
        });

        // Find the View that shows the facts category
        TextView comedy = (TextView) findViewById(R.id.podcast_news_comedy);
        // Set a click listener on that View
        comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comedyIntent = new Intent(MainActivity.this, ComedyActivity.class);
                startActivity(comedyIntent);
            }
        });
    }
}
