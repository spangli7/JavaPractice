package exams.mvc_sql_practice.gym_mem;


import exams.mvc_sql_practice.gym_mem.controller.Controller;
import exams.mvc_sql_practice.gym_mem.model.Commands;
import exams.mvc_sql_practice.gym_mem.model.Member;
import exams.mvc_sql_practice.gym_mem.model.TicketType;


import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        while (true){
            String s =  scanner.nextLine();
            if(s.equals("exit")){
                break;
            }
            String[] cmd = s.split(" ");

            if( Commands.getCommands(cmd[0]) == null ){
                System.out.println("wrong world");

            }else if(cmd[0].equals(Commands.ADD.code) && cmd[1].equals(Commands.USER.code)){
                Member m = new Member( cmd[2], cmd[3],cmd[4]);
                controller.addMember(m);
                System.out.println("add new member ");

            } else if(cmd[0].equals(Commands.ADD.code) && cmd[1].equals(Commands.TICKET.code) ) {
                TicketType t = new TicketType(cmd[2], Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
                controller.addTicket(t);
                System.out.println("add new ticketType ");

            }else if(cmd[0].equals(Commands.UPDATE.code) && cmd[1].equals(Commands.TICKET.code) ){
                TicketType t = new TicketType( cmd[2], Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
                controller.updateTicket(t);
                System.out.println("update ticketType ");

            } else if(cmd[0].equals(Commands.CHECK.code)){
                LocalDate to = controller.checkTicketValidity(Integer.parseInt(cmd[1]));
                System.out.println("today " + LocalDate.now() + "validity " + to);

            }else if(cmd[0].equals(Commands.GUESTS.code)){
                Map<Integer, Member> members = controller.getGuests();
                System.out.println(members);

            } else if(cmd[0].equals(Commands.BUY.code)){
               controller.buyTicket(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
            }

        }


    }
}
