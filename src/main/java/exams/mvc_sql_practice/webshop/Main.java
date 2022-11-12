package exams.mvc_sql_practice.webshop;


import exams.mvc_sql_practice.webshop.controller.Controller;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();

        while (true){
            String s =  sc.nextLine();
            if(s.equals("exit")){
                break;
            }
            String[] command = s.split(" ");

            if(command[0].equals("search")){
                System.out.println(controller.getProduct(command[1]));

            } else if(command[0].equals("add")){
                controller.addProductToCart( Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                System.out.println("add to cart");

            } else if(command[0].equals("check")){
                List<String> cart = controller.getCartContents(Integer.parseInt(command[1]));
                System.out.println(cart);

            }else if(command[0].equals("buy")){
                controller.finaliseOrder(Integer.parseInt(command[1]));

            } else if(command[0].equals("save")) {
                controller.saveProduct(Integer.parseInt(command[1]), command[2], Float.parseFloat(command[3]), Integer.parseInt(command[4]));
            }
            else if(command[0].equals("finish")) {
                System.out.println(" thank you for you shopping ");;
            }
        }

    }
}
