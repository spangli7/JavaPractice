package exams.oo_practice.lottery;

import common.file.GeneralFileReader;
import common.file.GeneralFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LotteryMain {

    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/lottery/lottosz.dat");

        List<String> inputData = reader.readLines();
        Scanner sc = new Scanner(System.in);

        LotteryManager manager = new LotteryManager(inputData);

        // 1.task
        System.out.println("\n1.task \nAdja meg az 52. heti számokat (89 24 34 11 64)");
        List<Integer> newNumbers = manager.newNumbers(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());

        // 2.task
        System.out.println("\n2.task");
        List<Integer> sortNewNumbers = manager.getSortNumbers(newNumbers);
        System.out.println(sortNewNumbers);

        // 3.task
        System.out.println("\n3.task \nAdjon meg egy számot 1-51között (21)");
        int number = sc.nextInt();

        // 4.task
        System.out.println("\n4.task");
        List<Integer> numbers = manager.getNumbersOfWeek(number);
        System.out.println(numbers);

        // 5.task
        System.out.println("\n5.task");
        boolean missingNumber = manager.missingNumbers();
        System.out.println((missingNumber) ? "van " : "nincs " );

        // 6.task
        int oddNumbers = manager.getOddNumbers();
        System.out.println("\n6.task \nÖsszesen " + oddNumbers + " páratlan szám található");

        // 7.task
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/lottery/lotto52.dat");

        List<List<Integer>> allLotteryNumbers = manager.getNewList(newNumbers);

        for (List<Integer> serialNumber : allLotteryNumbers) {
            for (int lotteryNumber : serialNumber) {
                writer.writeIntoFile( lotteryNumber + " ");
            }
            writer.writeIntoFile("\n");
        }
        System.out.println("\n7.task \nA fájl elkészült");

        // 8.task
        System.out.println("\n8.task");
        GeneralFileReader newReader = new GeneralFileReader("src/main/resources/exams/oo_practice/lottery/lotto52.dat");
        List<String> newLottery = newReader.readLines();

        Map<Integer,Integer> sumNumbers = manager.getSumNumbers(newLottery);

        for (int i = 1; i < 91; i++) {
            int lotteryNumber = sumNumbers.getOrDefault(i, 0);
            if(i % 15 == 0){
                System.out.print(lotteryNumber + "\n");
            }else{
                System.out.print(lotteryNumber + " ");
            }
        }
        System.out.println();

        // 9.task
        System.out.println("\n9.task");
        List<Integer> prims = manager.getIsPrimeNumber();
        List<Integer> missPrims = manager.getMissPrim(prims);
        System.out.println("A kimaradt prímszámok: " + missPrims  );




    }
}
