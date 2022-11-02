package exams.mvc_sql_practice.shop.model;

public class Customer {
    public String productName;
    public int productId;
    public int count;

    public Customer(String productName, int productId, int count) {
        this.productName = productName;
        this.productId = productId;
        this.count = count;
    }
}
