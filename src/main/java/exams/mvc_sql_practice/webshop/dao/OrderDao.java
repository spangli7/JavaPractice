package exams.mvc_sql_practice.webshop.dao;

import exams.mvc_sql_practice.webshop.model.Order;

import java.util.Map;

public interface OrderDao {
    // TODO: save order

    Map<Integer, Order> getOrders();

    void saveOrder(Order order);


}
