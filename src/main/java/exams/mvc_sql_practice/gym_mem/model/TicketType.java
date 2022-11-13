package exams.mvc_sql_practice.gym_mem.model;

public class TicketType {
    public int id;
    public String name;
    public int price;
    public int durationInDays;

    public TicketType(int id, String name, int price, int durationInDays) {
        this(name, price, durationInDays);
        this.id = id;
    }

    public TicketType( String name, int price, int durationInDays) {
        this.name = name;
        this.durationInDays = durationInDays;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInDays=" + durationInDays +
                ", price=" + price +
                '}';
    }
}
