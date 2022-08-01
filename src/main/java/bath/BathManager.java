package bath;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BathManager {

    private final List<BathData> allBathData;
    List<Integer> allPerson = new ArrayList<>();
    
    public BathManager(List<String> inputData) {
        allBathData = new ArrayList<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> inputData) {
        for (String row : inputData) {
            String[] data = row.split(" ");

            LocalTime localTime = LocalTime.of(Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]));

            Department id = Department.getDepartment(Integer.parseInt(data[1]));

            BathData bathData = new BathData(Integer.parseInt(data[0]), id, data[2].equals("0"), localTime);

            if(!allPerson.contains(bathData.getPersonId())){
                allPerson.add(bathData.getPersonId());
            }
            allBathData.add(bathData);
        }
    }

    public Guests getFirstAndLastGuest (){
        LocalTime time = null;

        for (BathData data : allBathData) {
            if(data.getLocation() == Department.OLTOZO && !data.isEntry()){
                time = data.getLocalTime();
            }
        }
        return new Guests(allBathData.get(0).getLocalTime(), time);
    }


    public int getAllGuestOnlyOnePlace(){
        Map<Integer, Integer> bathData = new HashMap<>();
        int sum = 0;

        for (BathData people : allBathData) {

            if( people.getLocation() != Department.OLTOZO){
                int place = !bathData.containsKey(people.getPersonId()) ? 0 : bathData.get(people.getPersonId());
                bathData.put(people.getPersonId(),++place);
            }
        }
        for (int data : bathData.values()) {
            if(data < 3){
                sum++;
            }
        }
        return sum;
    }


    public TimeSpentInBath getWhoLongestTime() {

        Map<Integer,TimeSpentInBath> timeSpent = new HashMap<>();

        for (BathData person : allBathData) {

            if(person.getLocation() == Department.OLTOZO){

                if(!timeSpent.containsKey(person.getPersonId()) ){
                    timeSpent.put(person.getPersonId(), new TimeSpentInBath(person.getLocalTime(),person.getPersonId()));
                }else{
                    timeSpent.get(person.getPersonId()).setEnd(person.getLocalTime());
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        TimeSpentInBath longestTime = null;

        for(TimeSpentInBath timeSpentInBath : timeSpent.values()) {
            if(timeSpentInBath.getDifferent() > maxTime){
                maxTime = timeSpentInBath.getDifferent();
                longestTime = timeSpentInBath;
            }
        }
        return longestTime;
    }


    public Time getAllGroups(){
        Time time = new Time();

        for (BathData allBathDatum : allBathData) {
            if (allBathDatum.getLocation() == Department.OLTOZO && allBathDatum.isEntry()) {
               time.setTime(allBathDatum.getLocalTime());
            }
        }
        return time;
    }

    public Map<Integer, Long> sauna(){
        Map<Integer,Long> allTime = new HashMap<>();

            for (int i = 0; i < allBathData.size(); i++) {
                BathData data = allBathData.get(i);

                if(data.getLocation() == Department.SZAUNAK && data.isEntry()){

                    long different = data.getLocalTime().until(allBathData.get(i+1).getLocalTime(), ChronoUnit.SECONDS);

                    if(!allTime.containsKey(data.getPersonId())){
                        allTime.put(data.getPersonId(),different);
                    } else{
                        long key = allTime.get(data.getPersonId());
                        key += different;
                        allTime.put(data.getPersonId(),key);
                    }
                }
            }
        return allTime;
    }


    public Map<Department, Set<Integer>> getWhichDepartmentHowMany(){
        Map<Department, Set<Integer>> allDepartments = new HashMap<>();

        for (int person : allPerson) {
            for (BathData data: allBathData) {

                if(person == data.getPersonId() && data.isEntry() && data.getLocation() != Department.OLTOZO ){

                    if(!allDepartments.containsKey(data.getLocation())){
                        Set<Integer> first = new HashSet<>();
                        first.add(data.getPersonId());
                        allDepartments.put(data.getLocation(),first);
                    } else{
                        Set<Integer> key = allDepartments.get(data.getLocation());
                        key.add(data.getPersonId());
                        allDepartments.put(data.getLocation(),key);
                    }
                }
            }
        }
        return allDepartments;
    }

}
