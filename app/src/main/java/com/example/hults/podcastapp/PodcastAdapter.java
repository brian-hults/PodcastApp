package com.example.hults.podcastapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PodcastAdapter extends ArrayAdapter<Podcast> {
    private static final String LOG_TAG = PodcastAdapter.class.getSimpleName();

    // Create a custom constructor for the custom class
    public PodcastAdapter(Activity context, ArrayList<Podcast> episodes) {
        // Initialize the internal storage for the context and list.
        super(context, 0, episodes);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Gets the index position of the current podcast episode
        Podcast currentEpisode = getItem(position);
        // Finds the current episode title TextView
        TextView episodeTitle = (TextView) listItemView.findViewById(R.id.episode_title);
        // Sets the episode title into the Title TextView
        episodeTitle.setText(currentEpisode.getEpisodeTitle());

        // Finds the current episode duration TextView
        TextView episodeDuration = (TextView) listItemView.findViewById(R.id.episode_duration);
        // Converts the int episode duration into a String to display in the TextView
        String length = "" + currentEpisode.getDuration() + " min";
        episodeDuration.setText(length);

        // Finds the current episode release date TextView
        TextView releaseDate = (TextView) listItemView.findViewById(R.id.episode_release_date);
        // Sets the release date into the Release Date TextView
        releaseDate.setText(currentEpisode.getReleaseDate());

        // Finds the current episode ImageView
        ImageView podcastImg = (ImageView) listItemView.findViewById(R.id.episode_img_view);
        // Sets the podcast image into the ImageView
        podcastImg.setImageResource(currentEpisode.getPodcastImg());

        // Finds the current episode description TextView
        TextView description = (TextView) listItemView.findViewById(R.id.episode_description);
        // Sets the episode description into the TextView
        description.setText(currentEpisode.getEpisodeDescription());

        return listItemView;
    }
}
