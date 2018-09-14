package com.example.hults.podcastapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DailyNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list);

        TextView podcastTitle = (TextView) findViewById(R.id.podcast_screen_title);
        podcastTitle.setText(R.string.podcast_daily_news);

        // Create an ArrayList of Podcast Episodes
        ArrayList<Podcast> episodes = new ArrayList<Podcast>();
        episodes.add(new Podcast( "Wednesday June 6, 2018", 12, R.drawable.daily_news, "6-June-2018", "Russia, North Korea, and China news"));
        episodes.add(new Podcast( "Thursday June 7, 2018", 11, R.drawable.daily_news, "7-June-2018", "Trade Wars"));
        episodes.add(new Podcast( "Friday June 8, 2018", 13, R.drawable.daily_news, "8-June-2018", "Humanitarian Crises"));
        episodes.add(new Podcast( "Monday June 11, 2018", 11, R.drawable.daily_news, "9-June-2018", "Conflict in the Middle East"));
        episodes.add(new Podcast( "Tuesday June 12, 2018", 12, R.drawable.daily_news, "10-June-2018", "United States scoffs G7 Summit"));
        episodes.add(new Podcast( "Wednesday June 13, 2018", 14, R.drawable.daily_news, "11-June-2018", "North Korea and Summit Preamble"));
        episodes.add(new Podcast( "Thursday June 14, 2018", 11, R.drawable.daily_news, "12-June-2018", "Singapore Summit Summary"));

        PodcastAdapter adapter = new PodcastAdapter(this, episodes);

        ListView listView = (ListView) findViewById(R.id.list_of_episodes);
        listView.setAdapter(adapter);

        // Set a click listener on that View that identifies which episode in the ListView was clicked on
        // and passes that episode's information on to the NowPlaying Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Podcast episode = (Podcast) parent.getAdapter().getItem(position);
                Intent intent = new Intent(DailyNewsActivity.this, NowPlayingActivity.class);
                String episodeTitle = episode.getEpisodeTitle();
                String episodeReleaseDate = episode.getReleaseDate();
                String episodeDescription = episode.getEpisodeDescription();
                int podcastImg = episode.getPodcastImg();
                intent.putExtra("Title", episodeTitle);
                intent.putExtra("Release Date", episodeReleaseDate);
                intent.putExtra("Description", episodeDescription);
                intent.putExtra("ImgViewID", podcastImg);
                intent.putExtra("Caller", "DailyNewsActivity");
                startActivity(intent);
            }
        });

    }
}
