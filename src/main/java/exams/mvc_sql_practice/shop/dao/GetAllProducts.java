package exams.mvc_sql_practice.shop.dao;

import common.sql.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetAllProducts {

    private static final String SQL_SELECT = "SELECT * FROM shop_product";

    public Map<Integer,String> getAllProducts(){
        Map<Integer,String> products = new HashMap<>();

        try ( Connection conn = ConnectionPool.getConnection())  {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while (rs.next()){
                products.put(rs.getInt("id"),rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }
}

