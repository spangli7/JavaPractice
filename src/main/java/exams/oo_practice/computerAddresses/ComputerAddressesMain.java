package exams.oo_practice.computerAddresses;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ComputerAddressesMain {

    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/computerAddresses/ip.txt");

        Scanner sc = new Scanner(System.in);

        // 1.task
        List<String> inputData = reader.readLines();
        ComputerAddressesManager addressManager = new ComputerAddressesManager(inputData);

        // 2.task
        int allRows = addressManager.getAllRows();
        System.out.println("\n2.task \nAz állományban " + allRows + " darab adatsor van.");

        // 3.task
        String smallest = addressManager.getSmallestAddress();
        System.out.println("\n3.task \nA legalacsonyabb tárolt IP-cím: " + smallest);

        // 4.task
        System.out.println("\n4.task");
        Map<AddressTypes, Integer> types = addressManager.getAllTypes();
        for (AddressTypes type : types.keySet()) {
            System.out.println(type + " cím: " + types.get(type) + " db.");
        }

        // 5.task
        Map<Integer,String> mostZero = addressManager.get18Zero();

        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/computerAddresses/sok.txt");

        for (int row : mostZero.keySet()) {
            writer.writeIntoFile(row + " " + mostZero.get(row));
        }
        System.out.println("\n5task \nA fájl elkészült");


        // 6.task
        System.out.println("\n6task \nAdjon meg egy sorszámot: (10)");
        int number = sc.nextInt();

        List<String> row = addressManager.getSmallRow(number);
        String originalRow = addressManager.getOriginalRow(number);
        System.out.println(originalRow + "\n" + String.join(":",row));
        int rowSize = row.size();

        // 7.task
        System.out.println("\n7.task");
        addressManager.shortenRow(row);

        if(row.size() == rowSize){
            System.out.println("Nem rövidíthető tovább.");
        }else{
            System.out.println(String.join(":",row));
        }
    }
}
