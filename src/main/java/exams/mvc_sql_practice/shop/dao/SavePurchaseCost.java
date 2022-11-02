package exams.mvc_sql_practice.shop.dao;


import common.sql.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SavePurchaseCost {

    private static final String SQL_SAVE = "INSERT INTO shop_purchase_cost (purchase_id,cost) VALUES(?,?) ";

    public void savePurchase(int id, int cost){

        try ( Connection conn = ConnectionPool.getConnection())  {

            PreparedStatement stmt = conn.prepareStatement(SQL_SAVE);
            stmt.setInt(1,id);
            stmt.setInt(2,cost);

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
