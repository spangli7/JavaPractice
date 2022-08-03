package courier;

import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CourierMain {

    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/coruier/tavok.txt");

        Scanner sc = new Scanner(System.in);

        List<String> rows = reader.readLines();


        // 1.task
        CourierManager courierManager = new CourierManager(rows);

        //2.task
        int firstWayKm = courierManager.getLengthOfFirstTrip();
        System.out.println("\n2.task \n" + (firstWayKm == 0 ? "A hét első napján a futár nem fdolgozott" :
                            "A hét első napján a futár  " + firstWayKm + " km-t tett meg."));

        //3.task
        int lastWay = courierManager.getLastWay();
        System.out.println("\n3.task \nA hét utolsó útja " + lastWay + " km volt ");

        // 4.task
        System.out.println("\n4.task");
        Set<Integer> missDays = courierManager.getDaysOff();

        System.out.println("A futár nem dolgozott a következő napokon");
        for (int day : missDays) {
            System.out.print(day + " ");
        }
        System.out.println();

        // 5.task
        System.out.println("\n5.task");
        int day = courierManager.getMostTransportDay();
        System.out.println("A legtöbb fuvar a " + day + " napon volt.");


        // 6.task
        System.out.println("\n6.task");
        Map<Integer,Integer> map = courierManager.getAllKmEveryDay();

        for (int mep : map.keySet()) {
            System.out.println(mep + ". nap " + map.get(mep) + " km.");
        }

        // 7.task
        System.out.println("\n7.feladat \nAdjon meg egy tavolsagot (7km)");
        System.out.println("A megadott km-hez "+Amount.getAmount(sc.nextInt()) + " ft díjazás jár." );

        // 8.task
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/coruier/dijazas.txt");
        List<String> allData =courierManager.getAmount();

        for (String row : allData) {
            writer.writeIntoFile(row + "\n");
        }
        System.out.println("\n8.task \nA fajl elkészült");

        // 9.task
        int sum = courierManager.getAllAmount();
        System.out.println("\n9.task \nA futár heti díjazása " + sum + "ft.");
    }
}
