package exams.mvc_sql_practice.webshop.dao.mock;

import exams.mvc_sql_practice.webshop.dao.OrderDao;
import exams.mvc_sql_practice.webshop.model.Order;

import java.util.Map;

public class InMemoryOrderDao implements OrderDao {


    @Override
    public Map<Integer, Order> getOrders() {
        return null;
    }

    @Override
    public void saveOrder(Order order) {


    }
}
