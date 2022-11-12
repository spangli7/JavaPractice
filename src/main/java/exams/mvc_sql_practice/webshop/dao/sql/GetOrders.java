package exams.mvc_sql_practice.webshop.dao.sql;




import exams.mvc_sql_practice.webshop.dao.OrderDao;
import exams.mvc_sql_practice.webshop.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetOrders implements OrderDao {

    private static final String SQL_SELECT = "SELECT * FROM web_shop_orders";
    @Override
    public Map<Integer, Order> getOrders(){
        Map<Integer, Order> orders = new HashMap<>();

        try (Connection conn =  ConnectionPool.getConnection()) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while(rs.next()){

                Order order = getOrder(rs);
                orders.put(order.id, order);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }

    private Order getOrder(ResultSet rs) throws SQLException {


        return new Order(rs.getInt("id"), rs.getInt("user_id"),rs.getFloat("price"),
                rs.getDate("order_time") );
    }


    @Override
    public void saveOrder(Order order) {

    }
}
