package exams.oo_practice.series;


import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SeriesController {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/exams/oo_practice/series/lista-1.txt";
        String outputFilePath = "src/main/resources/exams/oo_practice/series/summa.txt";

        GeneralFileReader myFileReader = new GeneralFileReader(inputFilePath);
        GeneralFileWriter writer = new GeneralFileWriter(outputFilePath);

        List<String> inputData = myFileReader.readLines();

        // 1. task
        Tasks tasks = new Tasks(inputData);

        // 2. task
        int numOfSeriesWithAirDate = tasks.countSeriesWithAirDate();
        System.out.println("\n2.feladat \nA listában "+ numOfSeriesWithAirDate + " vetitési dátummal rendelkező epizód van");

        // 3. task
        double percentOfWatched = tasks.getPercentOfWatchedSeries();
        System.out.printf("\n3.feladat \nA listában lévő epizódok %2.2f szazalekát már látta", percentOfWatched);

        // 4. task
        int totalWatchTime = tasks.countWatchTime();
        System.out.println("4.feladat \nSorozatnézéssel"  + formatWatchedMinutes(totalWatchTime) + "  töltött " );

        // 5. task
        System.out.println("\n5.feladat \nKérem adjon meg egy dátumot : 2017.10.18");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        List<Series> unseenSeries = tasks.getUnseenEpisodesUntilDate(year, month, day);
        for(Series s : unseenSeries) {
            System.out.println(s.getSeason() + "X" + s.getEpisode() + "   " + s.getSeriesName());
        }

        // 7. task
        System.out.println("\n7.feladat \nAdjon meg egy napot (cs)");
        String searchDay = scanner.nextLine();
        Set<String> nameOfSeries = tasks.getOnAirSeries(searchDay);

        if(nameOfSeries.isEmpty()){
            System.out.println("Az adott napon nem kerül adásba sorozat");
        } else {
            for (String name : nameOfSeries) {
                System.out.println(name);
            }
        }

        // 8. task
        Set<String> seriesNames = tasks.getAllSeriesName();
        for(String name : seriesNames) {
            SeriesDetails details = tasks.getSerieDetailByName(name);
            writer.writeIntoFile(name + " " + details.getTotalLength() +" "+ details.getNumberOfEpisodes() + "\n");
        }

        System.out.println("\n8.feladat\"A fájl elkészült");
    }

    private static String formatWatchedMinutes(int timeInMinutes){
        int day = timeInMinutes / (60 * 24);
        int remainder = timeInMinutes - day * (60 * 24);
        int hours = remainder / 60;
        int minutes = remainder - hours * 60;

        return day + " napot, " + hours + " órát, és " + minutes + " percet";
    }
}
