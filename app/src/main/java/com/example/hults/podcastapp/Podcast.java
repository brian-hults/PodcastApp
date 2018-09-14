package com.example.hults.podcastapp;

public class Podcast {
    private String mEpisodeTitle;
    private int mDuration;
    private int mImgResID;
    private String mReleaseDate;
    private String mDescription;

    public Podcast(String episodeTitle, int duration, int imgResID, String releaseDate, String description) {
        mEpisodeTitle = episodeTitle;
        mDuration = duration;
        mImgResID = imgResID;
        mReleaseDate = releaseDate;
        mDescription = description;
    }
    public String getEpisodeTitle() { return mEpisodeTitle;}
    public int getDuration() { return mDuration;}
    public int getPodcastImg() {return mImgResID;}
    public String getReleaseDate() {return mReleaseDate;}
    public String getEpisodeDescription() {return mDescription;}
}
