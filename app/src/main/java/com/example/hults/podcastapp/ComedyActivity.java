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

public class ComedyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list);

        TextView podcastTitle = (TextView) findViewById(R.id.podcast_screen_title);
        podcastTitle.setText(R.string.podcast_news_comedy);

        // Create an ArrayList of Podcast Episodes
        ArrayList<Podcast> episodes = new ArrayList<Podcast>();
        episodes.add(new Podcast("H. Jon Benjamin", 57, R.drawable.comedy_news, "10-June 2018", "The Voice of Archer and Bob's Burgers!"));
        episodes.add(new Podcast("Governor John Kasich", 62, R.drawable.comedy_news, "3-June 2018", "The Governor of Ohio"));
        episodes.add(new Podcast("David Duchovny", 59, R.drawable.comedy_news, "27-May 2018", "Star of The X-Files and Californication"));
        episodes.add(new Podcast("Krysten Ritter", 60, R.drawable.comedy_news, "20-May 2018", "Star of the Netflix Original Jessica Jones"));

        PodcastAdapter adapter = new PodcastAdapter(this, episodes);

        ListView listView = (ListView) findViewById(R.id.list_of_episodes);
        listView.setAdapter(adapter);

        // Set a click listener on that View that identifies which episode in the ListView was clicked on
        // and passes that episode's information on to the NowPlaying Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Podcast episode = (Podcast) parent.getAdapter().getItem(position);
                Intent intent = new Intent(ComedyActivity.this, NowPlayingActivity.class);
                String episodeTitle = episode.getEpisodeTitle();
                String episodeReleaseDate = episode.getReleaseDate();
                String episodeDescription = episode.getEpisodeDescription();
                int podcastImg = episode.getPodcastImg();
                intent.putExtra("Caller", "ComedyActivity");
                intent.putExtra("Title", episodeTitle);
                intent.putExtra("Release Date", episodeReleaseDate);
                intent.putExtra("Description", episodeDescription);
                intent.putExtra("ImgViewID", podcastImg);
                startActivity(intent);
            }
        });
    }
}