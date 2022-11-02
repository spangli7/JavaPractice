package exams.mvc_sql_practice.shop.dao;



import common.sql.ConnectionPool;
import exams.mvc_sql_practice.shop.model.Purchase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GetPurchase {

    private static final String SQL_SELECT = "SELECT * FROM shop_purchase";

    public List<Purchase> getPurchases(){
        List<Purchase> purchase = new ArrayList<>();

        try ( Connection conn = ConnectionPool.getConnection())  {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while (rs.next()){
                purchase.add(getPurchase(rs));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return purchase;
    }

    private Purchase getPurchase(ResultSet rs) throws SQLException {
        return new Purchase(rs.getInt("id"),rs.getInt("product_id"),rs.getInt("count"));
    }
}
