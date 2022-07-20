package expedition;

import common.GeneralFileReader;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpeditionMain {
    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/expedition/veetel.txt");

        List<String> inputData = reader.readLines();

        ExpeditionManager manager = new ExpeditionManager(inputData);

        Scanner sc = new Scanner(System.in);

        // 2.task
        int firstMessage = manager.getFirstMessage();
        int secondMessage = manager.getLastMessage();
        System.out.println("\n2.task \nAz első üzenet rögzítője: " + firstMessage
                + "\nAz utolsó üzenet rögzítője:" + secondMessage);


        // 3.task
        System.out.println("\n3.task");
        Map<Integer, Integer> radioData = manager.getRowWithWolf();
        for (int data : radioData.keySet()) {
            System.out.println(data + ". nap " + radioData.get(data) + " rádióamatőr");
        }


        // 4.task
        System.out.println("\n4.task");
        Map<Integer, Integer> map = manager.getGroupingOfDay();

        for (int day : map.keySet()) {
            System.out.println(day + ". nap " + map.get(day) + " rádióamatőr");
        }

        // 5.task
        System.out.println("\n5.task");
        Map<Integer, String> restoreMassages = manager.getMessageRestore();

        for (int day : restoreMassages.keySet()) {
            System.out.println(day + " " + restoreMassages.get(day));
        }

        // 6.task
        System.out.println("\n6.task \nA fügvény kész");

        // 7.task
        System.out.println("\n7.task \nAdjon meg egy napot és egy rádióamatőr sorszámát(2,15)");
        int day = sc.nextInt();
        int radioAmateur = sc.nextInt();

        String message = manager.getObservedIndividuals(day,radioAmateur);
        System.out.println(message);
    }
}
