package exams.mvc_sql_practice.webshop.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public int id;
    public int userId;
    public Map<Integer, Integer> productId;
    public float orderPrice;
    public Date orderTime;

    public Order(int id, int userId, float orderPrice, Date orderTime) {
        this(userId);
        this.id = id;
        this.orderPrice = orderPrice;
        this.orderTime = orderTime;
    }

    public Order(int userId) {
        this.userId = userId;
        this.productId = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + id +
                ", userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", orderTime=" + orderTime +
                '}';
    }
}
