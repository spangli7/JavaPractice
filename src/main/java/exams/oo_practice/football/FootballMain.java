package exams.oo_practice.football;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FootballMain {
    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/football/meccs.txt");

        List<String> inputData = reader.readLines();
        Scanner sc = new Scanner(System.in);

        // 1.task
        FootballManager manager = new FootballManager(inputData);

        // 2.task
        System.out.println("\n2.task \nAdjon meg egy forduló sorszámát");
        List<Match> matches = manager.getMatches(sc.nextInt());

        for (Match match : matches) {
            System.out.println(match.getHomeTeamName() + "-" +match.getGuestTeamName() + ": " +
                    match.getHomeTeamGoalsEndOfTheMatch() + "-" + match.getGuestTeamGoalsEndOfTheMatch() +
                    " (" + match.getHomeTeamGoalsHalfTime() + "-" + match.getGuestTeamGoalsHalfTime() + ")");
        }

        // 3.task
        System.out.println("\n3.task");
        Map<String,Integer> teams = manager.getComebacks();
        for (String team : teams.keySet()) {
            System.out.println(teams.get(team) + " " + team);
        }

        // 4.task
        System.out.println("\n4.task \nAdjon meg egy csapat nevet (Lelkesek)");
        String teamName = sc.next();

        // 5.task
        System.out.println("\n5.task");
        Goals goals = manager.getTeamGoals(teamName);
        System.out.println("Lőtt gólok: " + goals.getFiredGoals() + " Kapott gólok: " + goals.getReceivedGoals());

        // 6.task
        System.out.println("\n6.task");
        Match match = manager.getFirstLose(teamName);

        System.out.println((match == null)  ? "„A csapat otthon veretlen maradt"
                : match.getTurn() + " " + match.getGuestTeamName());

        // 7.task
        Map<String,Integer> statistic = manager.statistic();
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/football/stat.txt");

        for (String matchData : statistic.keySet()) {
            writer.writeIntoFile(matchData + ": " + statistic.get(matchData) + " db \n");
        }
        System.out.println("\n7.task \nA fájl elkészült");

    }
}
