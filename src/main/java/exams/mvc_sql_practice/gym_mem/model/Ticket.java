package exams.mvc_sql_practice.gym_mem.model;

import java.time.LocalDate;


public class Ticket {
    public int userId;
    public int price;
    public LocalDate from;
    public LocalDate to;
    public TicketType ticketType;

    @Override
    public String toString() {
        return "Ticket{" +
                "userId=" + userId +
                ", price=" + price +
                ", from=" + from +
                ", to=" + to +
                ", ticketType=" + ticketType +
                '}';
    }
}
