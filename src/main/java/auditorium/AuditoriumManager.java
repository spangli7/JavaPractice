package auditorium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuditoriumManager {
    Map<Integer, Map<Integer, Seat>> allSeat;
    Map<Integer, Seat> seat;

    public AuditoriumManager(List<String> bookedInput,List<String> categoryInput) {
        this.allSeat = new HashMap<>();
        parseInput(bookedInput);
        parseInput1(categoryInput);
    }

    private void parseInput(List<String> bookedInput) {

        for (int i = 0; i < bookedInput.size() ; i++) {
            seat = new HashMap<>();
            for (int j = 0; j < bookedInput.get(i).length() ; j++) {

                Seat seat1 = new Seat(bookedInput.get(i).charAt(j) =='x');
                seat.put(j, seat1);
            }
            allSeat.put(i,seat);
        }
    }
    private void parseInput1(List<String> categoryInput) {

        for (int i = 0; i < categoryInput.size() ; i++) {
            for (int j = 0; j < categoryInput.get(i).length() ; j++) {

                int number = Integer.parseInt(categoryInput.get(i).charAt(j)+"");

                Price price = Price.getPrice(number);

                allSeat.get(i).get(j).setPriceCategory(price);
            }
        }
    }

    public boolean booked(int row, int chair){
       return allSeat.get(row).get(chair).isBooked();
    }


    public int getAllSoldTickets(){
        int sold = 0;

        for(Map<Integer, Seat> booked : allSeat.values()) {

            for (int j = 0; j < booked.values().size(); j++) {

                if (booked.get(j).isBooked()) {
                    sold++;
                }
            }
        }
        return sold;
    }

    public int getMostTicketOfCategories() {
        Map<Integer, Integer> allCategories = new HashMap<>();

        for(Map<Integer, Seat> booked : allSeat.values()) {

            for (int j = 0; j < booked.values().size(); j++) {

                if( booked.get(j).isBooked() ){

                    int seatNumber = booked.get(j).getPriceCategory().number;

                    Integer db = allCategories.get(seatNumber);
                    allCategories.put(seatNumber, db == null ? 1 : db + 1);
                }
            }
        }

        int mostDB = Integer.MIN_VALUE;
        int key = 0;
        
        for (int db : allCategories.keySet()) {
            if(mostDB < allCategories.get(db)){
                key = db;
                mostDB = allCategories.get(db);
            }
        }
        return key;
    }


    public int getAllIncome(){
        int allMoney = 0;

        for(Map<Integer, Seat> booked : allSeat.values()) {
            for (int j = 0; j < booked.values().size(); j++) {
                allMoney += booked.get(j).getPriceCategory().price;
            }
        }
        return allMoney;
    }


    public int getAllEmptyChairs(){
        int allEmpty = 0;

        for(Map<Integer, Seat> booked : allSeat.values()) {
            for (int j = 0; j < booked.size(); j++) {


                boolean isLeftBooked = true;
                boolean isRightBooked = true;

                if(j > 0){
                    isLeftBooked = booked.get(j-1).isBooked();
                }

                if(j < booked.size()-1){
                    isRightBooked = booked.get(j+1).isBooked();
                }

                if(!booked.get(j).isBooked() && isRightBooked && isLeftBooked){
                    allEmpty++;
                }
            }
        }
        return allEmpty;
    }


    public String getPricesOfEmptyChair(){
        StringBuilder allChair = new StringBuilder();

        for(Map<Integer, Seat> booked : allSeat.values()) {

            for (int j = 0; j < booked.values().size(); j++) {

                if(!booked.get(j).isBooked()){
                    allChair.append(booked.get(j).getPriceCategory().number);
                } else{
                    allChair.append('x');
                }
            }
            allChair.append("\n");
        }
        return allChair.toString();
    }

}



