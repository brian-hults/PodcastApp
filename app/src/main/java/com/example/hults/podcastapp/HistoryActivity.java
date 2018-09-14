package com.example.hults.podcastapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list);

        TextView podcastTitle = (TextView) findViewById(R.id.podcast_screen_title);
        podcastTitle.setText(R.string.podcast_history);

        // Create an ArrayList of Podcast Episodes
        ArrayList<Podcast> episodes = new ArrayList<Podcast>();
        episodes.add(new Podcast("The Ministry of Ungentlemanly Warfare, Part 1", 43, R.drawable.history, "1-June 2018", "The real life James Bond"));
        episodes.add(new Podcast("The Ministry of Ungentlemanly Warfare, Part 2", 47, R.drawable.history, "4-June 2018", "The real life James Bond"));
        episodes.add(new Podcast("The USS Indianapolis", 50, R.drawable.history, "25-May 2018", "The Lost Ship has been Found"));
        episodes.add(new Podcast("The War between Great Britain and the Zulu Kingdom", 46, R.drawable.history, "14-May 2018", "The Untold Story of an African Conflict"));
        episodes.add(new Podcast("The Night of the Long Knives", 44, R.drawable.history, "7-May 2018", "How Hitler consolidated power"));
        episodes.add(new Podcast("USS Akron", 48, R.drawable.history, "1-May 2018", "The worst US Navy Airship disaster in history"));

        PodcastAdapter adapter = new PodcastAdapter(this, episodes);

        ListView listView = (ListView) findViewById(R.id.list_of_episodes);
        listView.setAdapter(adapter);

        // Set a click listener on that View that identifies which episode in the ListView was clicked on
        // and passes that episode's information on to the NowPlaying Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Podcast episode = (Podcast) parent.getAdapter().getItem(position);
                Intent intent = new Intent(HistoryActivity.this, NowPlayingActivity.class);
                String episodeTitle = episode.getEpisodeTitle();
                String episodeReleaseDate = episode.getReleaseDate();
                String episodeDescription = episode.getEpisodeDescription();
                int podcastImg = episode.getPodcastImg();
                intent.putExtra("Caller", "HistoryActivity");
                intent.putExtra("Title", episodeTitle);
                intent.putExtra("Release Date", episodeReleaseDate);
                intent.putExtra("Description", episodeDescription);
                intent.putExtra("ImgViewID", podcastImg);
                startActivity(intent);
            }
        });
    }
}