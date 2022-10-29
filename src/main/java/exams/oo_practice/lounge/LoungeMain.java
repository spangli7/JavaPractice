package exams.oo_practice.lounge;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoungeMain {
    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/lounge/ajto-1.txt");

        List<String> inputData = reader.readLines();
        Scanner scanner = new Scanner(System.in);

        // 1.task
        LoungeManager manager = new LoungeManager(inputData);

        // 2.task
        int firstPerson = manager.getFirstIn();
        int lastPerson = manager.getLastOut();
        System.out.println("\n2.task \nAz első belépő: " + firstPerson + "\nAz utolsó kilépő: " + lastPerson);

        // 3.task
        Map<Integer, Integer> allPeople = manager.getNumberOfLoungeVisi();
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/lounge/athaladas-1.txt");

        for (int people : allPeople.keySet()) {
            writer.writeIntoFile(people +" "+ allPeople.get(people) + " \n" );
        }
        System.out.println("\n3.task \nA fájl elkészült");

        // 4.task
        List<Integer> theyStayedInside = manager.getWhoStayedAfterMonitoring();
        System.out.println("\n4.task \nAkik a végén bent maradtak " + theyStayedInside);

        // 5.task
        LocalTime time = manager.getTimeOfMostPeopleInLounge();
        System.out.println("\n5.task \nPéldául "+ time + " voltak a legtöbben a társalgóban.");

        // 6.task
        System.out.println("\n6.task \nAdjon meg egy azonosítót (22)");
        int personId = scanner.nextInt();

        // 7.task
        System.out.println("\n7.task");
        List<PeopleData> allTime = manager.getSelectedPerson(personId);
        for(int i = 0; i < allTime.size(); i+=2){
            System.out.println((i+1 >= allTime.size()) ? allTime.get(i).getLocalTime()
                    : allTime.get(i).getLocalTime() + " " + allTime.get(i+1).getLocalTime());
        }

        // 8.task
        ObservedPerson personData = manager.getHowMuchTimeSheSpentInside(personId);
        System.out.println("\n8.task \nA " + personId + " személy összesen " + personData.getAllTime() / 60 + " percet volt bent," +
                " a megfigyelés végén " + ((personData.inOrOut) ? " nem volt bent  " : " bent volt " ));
    }
}
