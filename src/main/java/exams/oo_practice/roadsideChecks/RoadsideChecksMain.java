package exams.oo_practice.roadsideChecks;
import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Scanner;

public class RoadsideChecksMain {

    public static void main(String[] args) {

        GeneralFileReader reader =
                new GeneralFileReader("src/main/resources/exams/oo_practice/roadSideChecks/jarmu-1.txt");

        Scanner sc = new Scanner(System.in);

        List<String> inputData = reader.readLines();

        // 1.task
        RoadsideChecksManager manager = new RoadsideChecksManager(inputData);

        // 2.task
        int allHour = manager.getAllHourOfWork();
        System.out.println("\n2.feladat \nAznap legalább " + allHour + " órát dolgoztak.");

        // 3.task
        System.out.println("\n3.feladat ");
        List<String> vehicles = manager.getOneOrderPerHour();

        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // 4.task
        System.out.println("\n4.feladat");
        AllType sumType = manager.getSumOfAllTypes();
        System.out.println("Összesen " + sumType.bus + " autóbusz " + sumType.motorcycles + " motor " +
                            sumType.truck + " kamion és " + sumType.car + " kocsi haladt el az ellenörző pont előtt.");

        // 5.task
        String time = manager.getLongestQuietPeriod();
        System.out.println("\n5.feladat \nA leghosszabb forgalommentes időszak " + time);

        // 6.task
        System.out.println("\n6.feladat \nAdjon meg egy hiányos rendszámot (*A-7*3*) ");
        String carPlate = sc.nextLine();

        List<String> cars = manager.getEqualsCarPlate(carPlate);

        for (String car : cars) {
            System.out.println(car);
        }

        // 7.task
        List<Data> controllerCars = manager.getAllControlledVehicles();

        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/roadSideChecks/vizsgalt-1.txt");

        for (Data controllerCar: controllerCars) {
            writer.writeIntoFile(controllerCar.getLicensePlateNumber() + " \n");
        }
        System.out.println("\n7.feladat \nA fájl elkészült");
    }
}
