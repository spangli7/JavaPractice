package exams.oo_practice.courier;

import java.util.*;

public class CourierManager {

    public final List<TransportData> transports;

    public CourierManager(List<String> rows) {
        this.transports = new ArrayList<>();
        parseInput(rows);
    }

    public void parseInput(List<String> rows) {
        for (String row : rows) {
            String[] splitData = row.split(" ");

            int amount = Amount.getAmount(Integer.parseInt(splitData[2]));

            TransportData data = new TransportData(
                    Integer.parseInt(splitData[0]),
                    Integer.parseInt(splitData[1]),
                    Integer.parseInt(splitData[2]),
                    amount);
            transports.add(data);
        }
        Collections.sort(transports);
    }

    public int getLengthOfFirstTrip() {
        return transports.get(0).getKm();
    }

    public int getLastWay() {
        return transports.get(transports.size()-1).getKm();
    }

    public Set<Integer> getDaysOff() {
        Set<Integer> week = new HashSet<>();
        Set<Integer> daysOff = new HashSet<>();

        for (TransportData way : transports) {
            week.add(way.getDayNumber());
        }

        for (int i = 1; i < 8; i++) {
            if (!week.contains(i)) {
                daysOff.add(i);
            }
        }
        return daysOff;
    }

    public int getMostTransportDay() {
        Map<Integer,Integer> map = new HashMap<>();

        for (TransportData way : transports) {
            if (!map.containsKey(way.getDayNumber())) {
                map.put(way.getDayNumber(), way.getDeliveryNumber());
            } else{
                map.put(way.getDayNumber(), map.get(way.getDayNumber()) + way.getDeliveryNumber());
            }
        }
        int mostTransport = Integer.MIN_VALUE;

        for (int day : map.keySet()) {
            if(day > mostTransport){
                mostTransport = day;
            }
        }
        return mostTransport;
    }

    public Map<Integer,Integer> getAllKmEveryDay(){
        Map<Integer,Integer> kmPerDay = new HashMap<>();

        for (TransportData way : transports) {

            if(!kmPerDay.containsKey(way.getDayNumber())){
                kmPerDay.put(way.getDayNumber(),way.getKm());
            }else{
                int km = kmPerDay.get(way.getDayNumber());
                kmPerDay.put(way.getDayNumber(), way.getKm() + km);
            }
        }
        return kmPerDay;
    }


    public List<String> getAmount (){
        List<String> allData = new ArrayList<>();

        for (TransportData way : transports) {
            allData.add(way.getDayNumber() + " " + way.getDeliveryNumber() + " " + way.getAmount());
        }
        return allData;
    }

    public int getAllAmount(){
        int sumAmount = 0;
        for (TransportData way : transports) {
            sumAmount+= way.getAmount();
        }
        return sumAmount;
    }


}













