package exams.mvc_sql_practice.match;

import exams.mvc_sql_practice.match.controller.MatchManager;
import exams.mvc_sql_practice.match.model.ShotAndGot;
import exams.mvc_sql_practice.match.model.Team;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        MatchManager manager = new MatchManager();

        // 1.
        Scanner sc = new Scanner(System.in);
        System.out.println("adjon meg egy fordulót (10)");
        int roundNumber = sc.nextInt();

        List<String> matches = manager.getAllMatchOfRound(roundNumber);
        for (String match : matches) {
            System.out.println(match);
        }

        //2.
        Map<Integer, Set<Team>> reversal = manager.getAllTeamOfReversal();
        System.out.println(reversal);

        // 3.
        System.out.println("Adjon meg egy csapat nevet (Bogarak)");
        String team = sc.next();
        ShotAndGot goals = manager.getAllGoalsOfTeam(team);
        System.out.println("lött golok " + goals.shot + " kapott golok"+ goals.got);

        // 4.
        int defeatRound =  manager.getDefeatRoundOfTeam(team);
        System.out.println( defeatRound == 0 ? " A csapat otthon veretlen maradt. " : defeatRound);


        // 5.
        Map<String,Integer> allVariation = manager.getAllFinalIncidence();
        for (Map.Entry<String,Integer>  variation : allVariation.entrySet()) {
            System.out.println(variation.getKey() + " = " + variation.getValue());
        }
    }
}
