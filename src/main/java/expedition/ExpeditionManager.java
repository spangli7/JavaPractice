package expedition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpeditionManager {

    private final List<RadioData> allRadioData;

    public ExpeditionManager(List<String> inputData) {
        this.allRadioData = new ArrayList<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> inputData) {
        String[] strings = new String[0];
        for (int i = 0; i < inputData.size() ; i++) {

            if(i % 2 == 0){
                 strings = inputData.get(i).split(" ");
            }else{
                RadioData radioData = new RadioData(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), inputData.get(i));
                allRadioData.add(radioData);
            }
        }
    }

    public int getFirstMessage(){
        return allRadioData.get(0).getRadioAmateur();
    }

    public int getLastMessage(){
        return allRadioData.get(allRadioData.size()-1).getRadioAmateur();
    }

    public Map<Integer, Integer> getRowWithWolf(){
        Map<Integer, Integer>  allWolfRow = new HashMap<>();

        for (RadioData radio : allRadioData) {
            if(radio.getMessage().contains("farkas")){
                 allWolfRow.put(radio.getDay(), radio.getRadioAmateur());
            }
        }
        return allWolfRow;
    }

    public Map<Integer, Integer> getGroupingOfDay(){
        Map<Integer, Integer> allDay = new HashMap<>();

        for (int i = 1; i < 12; i++) {
            allDay.put(i,0);
        }

        for (RadioData radio : allRadioData) {

            int value = allDay.get(radio.getDay());
            value++;
            allDay.put(radio.getDay(), value);

        }
        return allDay;
    }

    public Map<Integer, String> getMessageRestore(){
        Map<Integer, String> massageOfDay = new HashMap<>();
        StringBuilder newMassage;

        for (int i = 1; i < 12 ; i++) {

            for (RadioData data : allRadioData) {

                if(data.getDay() == i){
                    newMassage = new StringBuilder();

                    if(!massageOfDay.containsKey(data.getDay())){
                        massageOfDay.put(data.getDay(), data.getMessage());
                    } else{

                        String massage = massageOfDay.get(i);

                        for (int j = 0; j < massage.length() ; j++) {

                            if(massage.charAt(j) == '#' ){
                                newMassage.append(data.getMessage().charAt(j));
                            }else if(massage.charAt(j) != '#'){
                                newMassage.append(massage.charAt(j));
                            }

                        }
                        massageOfDay.put(i,newMassage.toString());
                    }
                }
            }
        }
        return massageOfDay;
    }


    public boolean szame(String karaktersorozat){
        boolean answer = true;
        for (int j = 1; j < karaktersorozat.length() ; j++) {
            if (karaktersorozat.charAt(j) < '0' || karaktersorozat.charAt(j) > '9') {
                answer = false;
                break;
            }
        }
        return answer;
    }


    public String getObservedIndividuals(int day, int radioAmateur){
        String message = null;

        for (RadioData data : allRadioData) {
            if(day == data.getDay() && radioAmateur == data.getRadioAmateur() ){

                String[] split = data.getMessage().split(" ");

                String[] observation = split[0].split("/");

                if(observation[0] != null ){
                    if(observation[0].equals("0") || observation[0].contains("#") &&
                        observation[1].equals("0") ||observation[1].contains("#") ){
                        message = "nincs információ";
                    }else{
                        message = "a megfigyelt egyedek száma " +
                                (Integer.parseInt(observation[0]) + Integer.parseInt(observation[1]));
                    }
                } else {
                    message = "Nincs ilyen feljegyzés";
                }
            }
        }
        return message;
    }


}
