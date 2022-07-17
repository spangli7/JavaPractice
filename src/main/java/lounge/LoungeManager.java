package lounge;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LoungeManager {

    private final List<PeopleData> allPeople;
    static final LocalTime lastTime = LocalTime.of(15,0);

    public LoungeManager(List<String> inputData) {
        this.allPeople = new ArrayList<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> inputData) {

        for (String input : inputData) {
            String[] data = input.split(" ");

            LocalTime time = LocalTime.of(Integer.parseInt(data[0]),Integer.parseInt(data[1]));

            PeopleData peopleData = new PeopleData(time, Integer.parseInt(data[2]), data[3].equals("be"));
            allPeople.add(peopleData);
        }
    }


    public int getFirstIn(){
       return allPeople.get(0).getPersonId();
    }

    public int getLastOut(){
        int lastPersonId = 0;

        for (int i = allPeople.size()-1; i > 0; i--) {
            if(!allPeople.get(i).isIn()){
                lastPersonId = allPeople.get(i).getPersonId();
                break;
            }
        }
        return lastPersonId;
    }

    public Map<Integer, Integer> getNumberOfLoungeVisi(){
        Map<Integer, Integer> people = new HashMap<>();

        for (PeopleData peopleData : allPeople) {

            if(peopleData.isIn() && people.containsKey(peopleData.getPersonId())){
                int sum = people.get(peopleData.getPersonId());

                people.put(peopleData.getPersonId(),++sum);
            } else if(!people.containsKey(peopleData.getPersonId())){
                people.put(peopleData.getPersonId(),0);
            }
        }
        return people;
    }

    public List<Integer> getWhoStayedAfterMonitoring(){
        Set<Integer> peopleWhoLeft = new HashSet<>();
        Set<Integer> peopleWhoStayed = new HashSet<>();
        Set<Integer> peopleIds;

        for(int i = allPeople.size()-1; i >= 0; i--){
            PeopleData person = allPeople.get(i);

             peopleIds = person.isIn() ? peopleWhoStayed : peopleWhoLeft;

            if(!peopleWhoLeft.contains(person.getPersonId()) && !peopleWhoStayed.contains(person.getPersonId())) {
                peopleIds.add(person.getPersonId());
            }
        }
        List<Integer> copy = new ArrayList<>(peopleWhoStayed);

        Collections.sort(copy);
        return copy;
    }



    public LocalTime getTimeOfMostPeopleInLounge(){
        int inside = 0;
        int mostPeopleInside = 0;
        LocalTime time = null;

        for (PeopleData peopleData : allPeople) {

            if(peopleData.isIn()){
                inside++;
            }else{
                inside--;
            }

            if(inside > mostPeopleInside){
                mostPeopleInside = inside;
                time = peopleData.getLocalTime();
            }
        }
        return time;
    }


    public List<PeopleData> getSelectedPerson(int personId){
        List<PeopleData> allTime = new ArrayList<>();

        for (PeopleData peopleData : allPeople) {
            if(personId == peopleData.getPersonId()){
                allTime.add(peopleData);
            }
        }
        return allTime;
    }


    public ObservedPerson getHowMuchTimeSheSpentInside(int personId){
        int sumTime = 0;
        LocalTime timeSpentInside = null;
        long different;
        boolean outside = false;

        for (PeopleData people : allPeople) {
            outside = false;
            if(personId == people.getPersonId()){

                if(people.isIn()){
                    timeSpentInside = people.getLocalTime();

                } else{
                    outside = true;
                    different = timeSpentInside.until(people.getLocalTime(), ChronoUnit.SECONDS);
                    sumTime+= different;
                }
            }
        }
        if(!outside){
            sumTime += timeSpentInside.until(lastTime, ChronoUnit.SECONDS);
        }
        return new ObservedPerson(sumTime,outside);
    }
}
