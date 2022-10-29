package exams.oo_practice.auditorium;

import common.file.GeneralFileReader;
import common.file.GeneralFileWriter;

import java.util.List;
import java.util.Scanner;

public class AuditoriumMain {
    public static void main(String[] args) {

        GeneralFileReader booked = new GeneralFileReader("src/main/resources/exams/oo_practice/auditorium/foglaltsag.txt");
        GeneralFileReader category = new GeneralFileReader("src/main/resources/exams/oo_practice/auditorium/kategoria-4.txt");

        List<String> bookedInput = booked.readLines();
        List<String> categoryInput = category.readLines();

        final double allTickets = 300.0;
        Scanner sc = new Scanner(System.in);

        // 1.task
        AuditoriumManager manager = new AuditoriumManager(bookedInput,categoryInput);

        // 2.task
        System.out.println("\n2.task \nAdjon meg egy sort és egy széket(3/4)");
        int row = sc.nextInt();
        int chair = sc.nextInt();

        boolean place = manager.booked(row,chair);
        System.out.println((place) ? " foglalt " : " szabad ");

        // 3.task
        System.out.println("\n3.task");
        int soldTickets = manager.getAllSoldTickets();

        System.out.print("Az előadásra eddig " + soldTickets + " jegyet adtak el ez a nézőtér ");
        System.out.printf("%.0f",(soldTickets / allTickets ) * 100);
        System.out.println("%-a");

        // 4.task
        System.out.println("\n4.task");
        int mostTicketOfCategories = manager.getMostTicketOfCategories();
        System.out.println("A legtöbb jegyet a(z) "+ mostTicketOfCategories + ". árkategóriában értékesítették. " );


        // 5.task
        int sum = manager.getAllIncome();
        System.out.println("\n5.task \nA szinház bevétele a jelen pillanatban " + sum + "ft. ");

        // 6.task
        int db = manager.getAllEmptyChairs();
        System.out.println("\n6.task \nÖsszesen " + db + " db egyedülálló hely található");

        // 7.task
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/exams/oo_practice/auditorium/szabad-4.txt");
        writer.writeIntoFile(manager.getPricesOfEmptyChair());

        System.out.println("\n7.task \nA fájl elkészült");

    }
}
