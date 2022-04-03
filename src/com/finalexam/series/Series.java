package com.finalexam.series;

public class Series {

    private AirDate airDate;
    private String seriesName;
    private int season;
    private int episode;
    private int length;
    private boolean watched;

    public Series(AirDate airDate, String seriesName, int season, int episode, int length, boolean watched) {
        this.airDate = airDate;
        this.seriesName = seriesName;
        this.season = season;
        this.episode = episode;
        this.length = length;
        this.watched = watched;
    }

    public int getAirDateYear() {
        return airDate.getYear();
    }

    public int getAirDateMonth() {
        return airDate.getMonth();
    }

    public int getAirDateDay() {
        return airDate.getDay();
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public AirDate getAirDate() {
        return airDate;
    }

    public void setAirDate(AirDate airDate) {
        this.airDate = airDate;
    }
}
