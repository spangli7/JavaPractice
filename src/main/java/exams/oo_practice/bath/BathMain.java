package exams.oo_practice.bath;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BathMain {
    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/bath/furdoadat.txt");


        // 1.task
        List<String> dataInput = reader.readLines();
        BathManager manager = new BathManager(dataInput);

        // 2.task
        Guests guest = manager.getFirstAndLastGuest();
        System.out.println("\n2.task \nAz első vendég: " + guest.firstGuest.toString() + " kor lépett ki az öltözőböl" +
                "\nAz utolsó vendég: " + guest.lastGuest.toString() + " lépett ki az öltözőböl");
        // az utoldo nem jo

        // 3.task
        int allPerson = manager.getAllGuestOnlyOnePlace();
        System.out.println("\n3.task \nA fürdőben " + allPerson + " vendég járt csak egy helyen ");

        // 4.task
        TimeSpentInBath people = manager.getWhoLongestTime();
        System.out.println("\n4.task \nA legtöbb időt eltöltő vendég: \n" + people.getId() + " vendég " + LocalTime.ofSecondOfDay(people.getDifferent()));

        //5.task
        Time time = manager.getAllGroups();
        System.out.println("\n5.task \n6-9 óra között " + time.time6 + " vendég, \n"
                + "9-16 óra között " + time.tim9 + " vendég \n"
                + "16-20 óra között " + time.time16 + " vendég");

        // 6.task
        Map<Integer, Long> allTime = manager.sauna();
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/bath/szauna.txt");

        for (int person : allTime.keySet()) {
            writer.writeIntoFile(person + " " + LocalTime.ofSecondOfDay(allTime.get(person)) + "\n");
        }
        System.out.println("\n6.task \nA fájl elkészült");

        // 7.task
        System.out.println("\n7.task");
        Map<Department, Set<Integer>> departments = manager.getWhichDepartmentHowMany();

        for (Department department : departments.keySet()) {
            System.out.println(department + " " + departments.get(department).size());
        }
    }
}
