package exams.oo_practice.elections;

import common.PersonName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionsManager {

    public final List<VoteData> voteList;

    public ElectionsManager(List<String> rows) {
        this.voteList = new ArrayList<>();
        parseInput(rows);
    }

    public void parseInput(List<String> rows){

        for (String row : rows) {
            String[] split = row.split(" ");

            PersonName name = new PersonName(split[2],split[3]);

            VoteData voteData = new VoteData(name,Integer.parseInt(split[0]),Integer.parseInt(split[1]), PartiesType.getParties(split[4]));
            voteList.add(voteData);
        }
    }

    public int getAllStarting(){
        return voteList.size();
    }

    public int getAllVotesOfPerson(PersonName fullName){
        int sum = 0;

        for (VoteData vote : voteList) {
            if(vote.getPersonName().equals(fullName)){
                sum+= vote.getVote();
            }
        }
        return sum;
    }

    public int getAllVotes(){
        int sum = 0;

        for (VoteData vote : voteList) {
            sum+= vote.getVote();
        }
        return sum;
    }

    public Map<PartiesType,Integer> getAllPartVotes(){
        Map<PartiesType,Integer> partyVotes = new HashMap<>();

        for (VoteData vote : voteList) {
            if(!partyVotes.containsKey(vote.getPartiesType())) {
                partyVotes.put(vote.getPartiesType(), 0);
            }

            int storedVotes = partyVotes.get(vote.getPartiesType());
            partyVotes.put(vote.getPartiesType(), storedVotes + vote.getVote());
        }
        return partyVotes;
    }


    public int getWinner(){
        VoteData mostVotes = voteList.get(0);

        for(VoteData vote : voteList) {
            if(mostVotes.getVote() < vote.getVote()) {
                mostVotes = vote;
            }
        }
        return mostVotes.getVote();
    }

    public Map<Integer,VoteData> getAllWinnerOfDistrict(){
        Map<Integer,VoteData> winners = new HashMap<>();

        for(VoteData vote : voteList) {
            if(!winners.containsKey(vote.getSerialNumber())){
                winners.put(vote.getSerialNumber(),vote);
            }else{
                VoteData currentVote = winners.get(vote.getSerialNumber());

                if(vote.getVote() > currentVote.getVote()){
                    winners.put(vote.getSerialNumber(),vote);
                }
            }
        }
        return winners;
    }
}
