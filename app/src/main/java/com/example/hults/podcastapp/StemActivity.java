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

public class StemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list);

        TextView podcastTitle = (TextView) findViewById(R.id.podcast_screen_title);
        podcastTitle.setText(R.string.podcast_stem);

        // Create an ArrayList of Podcast Episodes
        ArrayList<Podcast> episodes = new ArrayList<Podcast>();
        episodes.add(new Podcast("Evolution", 55, R.drawable.stem, "6-June 2018", "How are current species evolving to adapt with the world of Humanity?"));
        episodes.add(new Podcast("Space Exploration", 57, R.drawable.stem, "1-June 2018", "Treasures and Ramifications of Space Travel"));
        episodes.add(new Podcast("Solve for X", 58, R.drawable.stem, "23-May 2018", "The Usefulness of Mathematics in Modern Life"));
        episodes.add(new Podcast("Rethinking Medicine", 59, R.drawable.stem, "14-May 2018", "New Approaches and Solutions to Diseases"));
        episodes.add(new Podcast("Big Data", 54, R.drawable.stem, "4-May 2018", "How do we interact with our Data?"));

        PodcastAdapter adapter = new PodcastAdapter(this, episodes);

        ListView listView = (ListView) findViewById(R.id.list_of_episodes);
        listView.setAdapter(adapter);

        // Set a click listener on that View that identifies which episode in the ListView was clicked on
        // and passes that episode's information on to the NowPlaying Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Podcast episode = (Podcast) parent.getAdapter().getItem(position);
                Intent intent = new Intent(StemActivity.this, NowPlayingActivity.class);
                String episodeTitle = episode.getEpisodeTitle();
                String episodeReleaseDate = episode.getReleaseDate();
                String episodeDescription = episode.getEpisodeDescription();
                int podcastImg = episode.getPodcastImg();
                intent.putExtra("Caller", "StemActivity");
                intent.putExtra("Title", episodeTitle);
                intent.putExtra("Release Date", episodeReleaseDate);
                intent.putExtra("Description", episodeDescription);
                intent.putExtra("ImgViewID", podcastImg);
                startActivity(intent);
            }
        });
    }
}