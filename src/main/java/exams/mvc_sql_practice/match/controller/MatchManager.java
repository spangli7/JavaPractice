package exams.mvc_sql_practice.match.controller;



import exams.mvc_sql_practice.match.model.*;
import exams.mvc_sql_practice.match.sql.GetAllMatchOfRound;
import exams.mvc_sql_practice.match.sql.GetAllTeam;

import java.util.*;

public class MatchManager {

    GetAllMatchOfRound round = new GetAllMatchOfRound();
    GetAllTeam allTeam = new GetAllTeam();


    public List<String> getAllMatchOfRound(int roundNumber){
        List<Match> allMatch = round.getAllMatchOfRound();
        Map<Integer, Team> teams =  allTeam.getAllTeam();

        List<String> round = new ArrayList<>();

        for (Match match : allMatch) {
            if(match.round == roundNumber){
                round.add( teams.get(match.homTeamId).name + "-" + teams.get(match.oppTeamId).name
                        + ": "+ match.homGoals+"-"+match.oppGoals +" ("+
                        match.halfTimeHomGoals+"-"+match.halfTimeOppGoals +")");
            }
        }

        return round;
    }


    public Map<Integer,Set<Team>>  getAllTeamOfReversal(){
        List<Match> allMatch = round.getAllMatchOfRound();
        Map<Integer,Team> teams =  allTeam.getAllTeam();

        Map<Integer,Set<Team>> reversalTeam = new HashMap<>();

        for (Match match : allMatch) {
            int teamId = 0;
            if( match.halfTimeHomGoals > match.halfTimeOppGoals && match.homGoals < match.oppGoals){
                teamId = match.oppTeamId;

            }else if(match.halfTimeHomGoals < match.halfTimeOppGoals && match.homGoals > match.oppGoals){
                teamId = match.homTeamId;

            }
            if(teamId > 0){
                reversalTeam.computeIfAbsent(match.round,t-> new HashSet<>())
                        .add(teams.get(teamId));
            }
        }
        return reversalTeam;
    }

    public ShotAndGot getAllGoalsOfTeam(String teamName){
        List<Match> allMatch = round.getAllMatchOfRound();

        int shot = 0;
        int got = 0;

        int id = getId(teamName);

        for (Match match : allMatch) {
            if(match.homTeamId == id ){
                shot += match.homGoals;
                got += match.oppGoals;
            } else if( match.oppTeamId == id){
                shot += match.oppGoals;
                got += match.homGoals;
            }
        }
        return new ShotAndGot(shot,got);
    }


    public int getDefeatRoundOfTeam(String teamName){
        List<Match> allMatch = round.getAllMatchOfRound();
        int id = getId(teamName);
        for (Match match : allMatch) {
            if(match.homTeamId == id && match.homGoals < match.oppGoals){
                return match.round;
            }
        }
        return 0;
    }


    public Map<String,Integer> getAllFinalIncidence(){
        List<Match> allMatch = round.getAllMatchOfRound();
        Map<String,Integer> allVariation = new HashMap<>();

        for (Match match : allMatch) {
            String simple = match.homGoals + " " + match.oppGoals;
            String reverse = match.oppGoals + " " + match.homGoals;

            int sum = allVariation.computeIfAbsent(simple,m-> 0);
            sum++;
            allVariation.put(simple,sum);
            allVariation.put(reverse,sum);
        }
        return allVariation;
    }




    public int getId(String teamName){
        Map<Integer,Team> teams =  allTeam.getAllTeam();

        for (Integer teamId : teams.keySet()) {
            if(teams.get(teamId).name.equals(teamName)){
                return teamId;
            }
        }
        return 0;
    }

}
