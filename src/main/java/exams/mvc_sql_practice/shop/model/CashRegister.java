package exams.mvc_sql_practice.shop.model;

import java.util.List;

public class CashRegister {
    public List<String> products;
    public int amount;

    @Override
    public String toString() {
        return  products +
                " amount: " + amount +"\n";
    }
}
