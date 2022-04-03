package com.finalexam.series;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tasks {
    private List<Series> allSeries;

    public Tasks(List<String> rows) {
        this.allSeries = new ArrayList<>();
        parseInput(rows);
    }

    private void parseInput(List<String> rows){
        for (int i = 0; i < rows.size(); i+=5) {
            AirDate airDate = "NI".equals(rows.get(i)) ? null : new AirDate(rows.get(i));
            String[] seasonEpisode = rows.get(i+2).split("x");

            Series types = new Series(airDate, rows.get(i+1), Integer.parseInt(seasonEpisode[0]),
                    Integer.parseInt(seasonEpisode[1]), Integer.parseInt(rows.get(i+3)), rows.get(i+4).equals("1"));
            allSeries.add(types);
        }
    }

    public int countSeriesWithAirDate(){
        int summ = 0;

        for (Series series : allSeries) {
            if (series.getAirDate() != null){
                summ++;
            }
        }

        return summ;
    }

    public double getPercentOfWatchedSeries(){
        double watched = 0;

        for (Series seria : allSeries) {
            if (seria.isWatched()) {
                watched++;
            }
        }
        double percent = watched  / allSeries.size() * 100;

        return percent;
    }

    public int countWatchTime(){
        int allTime = 0;

        for (Series series : allSeries) {
            if(series.isWatched()){
                allTime += series.getLength() ;
            }
        }

        return allTime;
    }

    public List<Series> getUnseenEpisodesUntilDate(int year, int month, int day) {
        List<Series> unseenSeries = new ArrayList<>();

        for (Series series : allSeries) {
            if(series.getAirDate() != null
                    && series.getAirDateYear() <= year
                    && series.getAirDateMonth() <= month
                    && series.getAirDateDay() <= day
                    && !series.isWatched()) {

                unseenSeries.add(series);
            }
        }

        return unseenSeries;
    }

    public Set<String> getOnAirSeries(String dayOfWeek) {
        Set<String> seriesNames = new HashSet<>();

        for (Series series : allSeries) {
            if(series.getAirDate() != null){
                String day = hetnapja(series.getAirDateYear(), series.getAirDateMonth(), series.getAirDateDay());

                if(dayOfWeek.equals(day)){
                    seriesNames.add(series.getSeriesName());
                }
            }
        }

        return seriesNames;
    }

    public Set<String> getAllSeriesName(){
        Set<String> allSeriesName = new HashSet<>();

        for (Series series : allSeries) {
            allSeriesName.add(series.getSeriesName());
        }

        return allSeriesName;
    }

    public SeriesDetails getSerieDetailByName(String name){
        int totalLength = 0;
        int numberOfEpisodes = 0;

        for (Series serie : allSeries) {
            if(name.equals(serie.getSeriesName())){
                totalLength += serie.getLength();
                numberOfEpisodes ++;
            }
        }

        return new SeriesDetails(numberOfEpisodes, totalLength);
    }

    private String hetnapja(int year, int month, int day){
        String[] days = {"v", "h", "k", "sze", "cs", "p", "szo" };
        int[] months = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        if(month < 3 ){
            year -= 1;
        }

        return days[ ( year + year / 4 - year / 100 + year / 400 + months[month-1] + day) % 7];
    }
}
