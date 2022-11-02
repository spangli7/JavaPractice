package exams.mvc_sql_practice.shop;


import exams.mvc_sql_practice.shop.controller.ShopController;
import exams.mvc_sql_practice.shop.model.CashRegister;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ShopController controller = new ShopController();
        Scanner sc = new Scanner(System.in);

        final String PRODUCT = "csavarkulcs";

        // 1.task
        int allBuying = controller.getAllBuying();
        System.out.println("osszesen " + allBuying + " szor fizettek");

        // 2.task
        int customerPurchase = controller.getFirstCustomerPurchase();
        System.out.println("\nAz elso vasarlonak " + customerPurchase + " db termeke volt");

        // 3.task
        int firstCustomer = controller.getFirstCustomerByBought(PRODUCT);
        System.out.println( (firstCustomer != 0 ) ? "\nA(z) elso vasarlo aki vett a(z) " + firstCustomer + ". vasarlo volt."
                : "\nSenki nem vett ");

        int lastCustomer = controller.getLastCustomerByBought(PRODUCT);
        System.out.println( (lastCustomer != 0 ) ? "A(z) utolsó vasarlo aki vett a(z) " + lastCustomer + ". vasarlo volt"
                : "Senki nem vett ");

        // 4.task
        int db = controller.getAllCustomersByBought(PRODUCT);
        System.out.println("\nOsszesen " + db + " db " + PRODUCT + "ot vettek");

        // 5.task
        System.out.println("Andjon meg egy felhasznalo Id-t (21)");
        CashRegister products = controller.getAllProductsByCustomer(sc.nextInt());
        System.out.println("\n " + products);

        // 6.task
        controller.savePurchaseCost();

    }
}
