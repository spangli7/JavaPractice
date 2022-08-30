package lottery;

import java.util.*;

public class LotteryManager {

    public final List<List<Integer>> lotteries;
    public Set<Integer> allNumbers = new HashSet<>();
    public List<Integer> newAllNumbers =new ArrayList<>();

    public LotteryManager(List<String> lotteries) {
        this.lotteries = new ArrayList<>();
        parseInput(lotteries);
    }

    private void parseInput(List<String> rows) {

        for (String  row : rows) {
            String[] number = row.split(" ");

            lotteries.add(newNumbers(Integer.parseInt(number[0]), Integer.parseInt(number[1]), Integer.parseInt(number[2]),
                    Integer.parseInt(number[3]),Integer.parseInt(number[4])));

            allNumbers.add(Integer.parseInt(number[0]));
            allNumbers.add(Integer.parseInt(number[1]));
            allNumbers.add(Integer.parseInt(number[2]));
            allNumbers.add(Integer.parseInt(number[3]));
            allNumbers.add(Integer.parseInt(number[4]));
        }
    }


    public List<Integer> newNumbers(int one, int two, int three, int four, int five){
        List<Integer> newNumbers = new ArrayList<>();

        newNumbers.add(one);
        newNumbers.add(two);
        newNumbers.add(three);
        newNumbers.add(four);
        newNumbers.add(five);

        return newNumbers;
    }



    public List<Integer> getSortNumbers( List<Integer> newNumbers){
        Collections.sort(newNumbers);
        return newNumbers;
    }

    public List<Integer> getNumbersOfWeek(int number){
        return lotteries.get(number-1);
    }

    public boolean missingNumbers(){
        for (int i = 1; i < 90 ; i++) {
            if(!allNumbers.contains(i)){
                return  true;
            }
        }
        return false;
    }

    public int getOddNumbers(){
        int oddNumbers = 0;
        for (int number : allNumbers) {
            if(number % 2 != 0){
                oddNumbers++;
            }
        }
        return oddNumbers;
    }

    public List<List<Integer>> getNewList(List<Integer> newNumbers){
        lotteries.add(newNumbers);
        return lotteries;
    }

    public Map<Integer,Integer> getSumNumbers(List<String> newLottery ){
        Map<Integer,Integer> sumNumbers = new HashMap<>();

        for (String  numbers : newLottery) {
            String[] number = numbers.split(" ");
            newAllNumbers.add(Integer.parseInt(number[0]));
            newAllNumbers.add(Integer.parseInt(number[1]));
            newAllNumbers.add(Integer.parseInt(number[2]));
            newAllNumbers.add(Integer.parseInt(number[3]));
            newAllNumbers.add(Integer.parseInt(number[4]));
        }

        for (int number : newAllNumbers) {
            if(!sumNumbers.containsKey(number)){
                sumNumbers.put(number,1);
            }else{
                int sum = sumNumbers.get(number);
                sumNumbers.put(number, ++sum);
            }
        }

        return sumNumbers;
    }


    public List<Integer> getIsPrimeNumber(){
        List<Integer> prims = new ArrayList<>();
        int sum ;
        for (int i = 2; i < 90 ; i++) {
            sum = 0;
            for (int j = 2; j <= i ; j++) {

                if(i % j == 0 ){
                    sum++;
                }
            }
            if(sum < 2){
                prims.add(i);
            }
        }
        return prims;
    }



    public List<Integer> getMissPrim(List<Integer> prims){
        List<Integer> missPrims = new ArrayList<>();

        for (int numbers : prims) {
            if(!allNumbers.contains(numbers)){
                missPrims.add(numbers);
            }
        }

        return missPrims;
    }












}
