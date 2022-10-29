package exams.oo_practice.fence;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Scanner;

public class StreetMain {

    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/fence/kerites.txt");
        Scanner scanner = new Scanner(System.in);

        // 1.task
        List<String> inputData = reader.readLines();
        StreetManager streetManager = new StreetManager(inputData);

        // 2.task
        int plotsSold = streetManager.getNumberOfPlotsSold();
        System.out.println("\n2.feladat \nAz eladott telkek száma " + plotsSold);

        // 3.task
        StreetData lastPlot = streetManager.getLastPlot();

        System.out.println("\n3.feladat \nA" + (lastPlot.isOdd()
                ? "páros " :
                " páratlan ") + "oldalon adták el az utolsó telket " +
                "\nAz utolsó telek száma : " + lastPlot.getHouseNumber());


        // 4.task
        int houseNumber = streetManager.getShameFenceColor();
        System.out.println("\n4.feladat \nA szomszédossal egyezik a kerítés színe " + houseNumber);

        // 5.task
        System.out.println("\n5.feladat \nAdjon meg egy eladott telket (83)");
        int house = scanner.nextInt();

        List<String> potData = streetManager.getPlot(house);
        System.out.println("\nA kerítés színe / állapota: " + potData.get(0));
        System.out.println("Egy lehetséges szín: " + potData.get(1));

         // 6.task
        System.out.println("6.feladat");
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/fence/utcakép.txt");

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (StreetData evenHouse : streetManager.street) {
            writer.writeIntoFile(streetManager.getColorCodeOfHouse(evenHouse));
            sb.append(streetManager.getHouseNumberCodeOfHouse(evenHouse));
        }
        writer.writeIntoFile(sb.toString());
    }
}
