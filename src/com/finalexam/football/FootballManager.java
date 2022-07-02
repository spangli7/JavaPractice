package com.finalexam.football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballManager {

    private final List<Match> allMatch;
    int allTeam;

    public FootballManager(List<String> inputData) {
        this.allMatch = new ArrayList<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> inputData) {
        for (int i = 0; i < inputData.size(); i++) {

            if(i == 0){
                allTeam = Integer.parseInt(inputData.get(0));
            } else{
                String[] row = inputData.get(i).split(" ");

                Match matches = new Match(Integer.parseInt(row[0]),Integer.parseInt(row[1]),Integer.parseInt(row[2]),
                        Integer.parseInt(row[3]),Integer.parseInt(row[4]),row[5],row[6]);
                allMatch.add(matches);
            }
        }
    }

    public List<Match> getMatches(int number){
        List<Match> allMatches = new ArrayList<>();


        for (Match match : allMatch) {
            if(number == match.getTurn()){
                allMatches.add(match);
            }
        }
        return allMatches;
    }

    public Map<String,Integer> getComebacks(){
        Map<String,Integer> teams = new HashMap<>();

        for (Match match : allMatch) {

            if(match.getHomeTeamGoalsHalfTime() > match.getGuestTeamGoalsHalfTime() &&
                match.getHomeTeamGoalsEndOfTheMatch() < match.getGuestTeamGoalsEndOfTheMatch()){

                teams.put(match.getGuestTeamName(),match.getTurn());

            }else if( match.getHomeTeamGoalsHalfTime() < match.getGuestTeamGoalsHalfTime() &&
                    match.getHomeTeamGoalsEndOfTheMatch() > match.getGuestTeamGoalsEndOfTheMatch()) {

                teams.put(match.getHomeTeamName(),match.getTurn());
            }
        }
        return teams;
    }

    public Goals getTeamGoals(String teamName){
        int scoredGoals = 0;
        int receivedGoals = 0;

        for (Match match : allMatch) {
            if(match.getHomeTeamName().equals(teamName)){
                scoredGoals += match.getHomeTeamGoalsEndOfTheMatch();
                receivedGoals += match.getGuestTeamGoalsEndOfTheMatch();

            }else if(match.getGuestTeamName().equals(teamName)){
                scoredGoals += match.getGuestTeamGoalsEndOfTheMatch();
                receivedGoals += match.getHomeTeamGoalsEndOfTheMatch();
            }
        }
        return new Goals(receivedGoals,scoredGoals);
    }

    public Match getFirstLose(String teamName){
        Match matches = null;

        for (Match match : allMatch) {
            if(teamName.equals(match.getHomeTeamName())){

                if(match.getHomeTeamGoalsEndOfTheMatch() < match.getGuestTeamGoalsEndOfTheMatch()){
                    matches = match;
                    break;
                }
            }
        }
        return matches;
    }


    public Map<String,Integer> statistic(){
        Map<String,Integer> statistic = new HashMap<>();
        int larg;
        int small;

        for (Match match : allMatch) {
            if(match.getHomeTeamGoalsEndOfTheMatch() > match.getGuestTeamGoalsEndOfTheMatch()){
                larg = match.getHomeTeamGoalsEndOfTheMatch();
                small = match.getGuestTeamGoalsEndOfTheMatch();
            } else{
                larg = match.getGuestTeamGoalsEndOfTheMatch();
                small = match.getHomeTeamGoalsEndOfTheMatch();
            }

            String matchResult = larg + "-" + small;

            if(!statistic.containsKey(matchResult)){
                statistic.put(matchResult,1);
            } else{
                int key = statistic.get(matchResult);
                key++;
                statistic.put(matchResult,key);
            }
        }
        return statistic;
    }
}
