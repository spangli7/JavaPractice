package roadsideChecks;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class RoadsideChecksManager {

    private final List<Data> allChecks;

    public RoadsideChecksManager(List<String> rows){
        this.allChecks = new ArrayList<>();
        parseInput(rows);
    }

    public void parseInput(List<String> rows){

        for (String row : rows) {
            String[] splitTimeAndID = row.split(" ");

            LocalTime time = LocalTime.of(
                    Integer.parseInt(splitTimeAndID[0]),
                    Integer.parseInt(splitTimeAndID[1]),
                    Integer.parseInt(splitTimeAndID[2]));

            Data data = new Data(time,splitTimeAndID[3]);
            allChecks.add(data);
        }
    }

    public int getAllHourOfWork(){
    return allChecks.get(allChecks.size()-1).getLocalTime().getHour()+1 - allChecks.get(0).getLocalTime().getHour();
    }

    public List<String> getOneOrderPerHour(){

        List<String> orderPerHour = new ArrayList<>();
        int lastCheckedHour = - 1;

        for (Data check : allChecks) {
            if (check.getLocalTime().getHour() > lastCheckedHour){
                lastCheckedHour = check.getLocalTime().getHour();
                orderPerHour.add(check.getLocalTime().getHour() + " óra - " + check.getLicensePlateNumber());
            }
        }
        return orderPerHour;
    }

    public AllType getSumOfAllTypes(){
        AllType allType = new AllType();

        for (Data check : allChecks) {

            VehicleType sign = VehicleType.getVehicleType(String.valueOf(check.getLicensePlateNumber().charAt(0)));

            if(VehicleType.BUS == sign){
                allType.bus++;
            }
            if(VehicleType.TRUCK == sign){
                allType.truck++;
            }
            if(VehicleType.MOTORCYCLES == sign){
                allType.motorcycles++;
            }else{
                allType.car++;
            }
        }
        return allType;
    }

    public String getLongestQuietPeriod(){
        long mostDifferent = Integer.MIN_VALUE;
        LocalTime first = null;
        LocalTime second = null;

        for (int i = 0; i < allChecks.size()-1 ; i++) {

            long different = allChecks.get(i).getLocalTime().until(allChecks.get(i+1).getLocalTime(), ChronoUnit.SECONDS);

            if( different > mostDifferent){
                mostDifferent = different;
                first = allChecks.get(i).getLocalTime();
                second = allChecks.get(i+1).getLocalTime();
            }
        }
        return first + " " + second;
    }

    public List<String> getEqualsCarPlate(String carPlate) {
        List<String> cars = new ArrayList<>();

        String plateNumber = null;

        for (Data check : allChecks) {
            for (int i = 0; i < carPlate.length(); i++) {
                if(carPlate.charAt(i) != '*' && carPlate.charAt(i) != '-'  ){

                    if(carPlate.charAt(i) == check.getLicensePlateNumber().charAt(i)){
                        plateNumber = check.getLicensePlateNumber();
                    } else{
                        plateNumber = null;
                        break;
                    }
                }
            }
            if(plateNumber != null){
                cars.add(check.getLicensePlateNumber());
            }
        }
        return cars;
    }


    public List<Data> getAllControlledVehicles(){
        List<Data> cars = new ArrayList<>();

        LocalTime helper = allChecks.get(0).getLocalTime();

        for(Data check : allChecks) {

            if(helper.isBefore(check.getLocalTime()) || helper.equals(check.getLocalTime())){
                cars.add(check);
                helper = check.getLocalTime();
                helper = helper.plusMinutes(5);
            }
        }
        return cars;
    }
}
