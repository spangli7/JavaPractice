package exams.mvc_sql_practice.webshop.dao.sql;


import exams.mvc_sql_practice.webshop.dao.ProductDao;
import exams.mvc_sql_practice.webshop.model.Product;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetProducts implements ProductDao {

    private static final String SQL_SELECT = "SELECT * FROM web_shop_products";
    private static final String SQL_UPDATE = "UPDATE web_shop_products SET number_in_stock = ?  where id = ?";
    private static final String SQL_INSERT =  "INSERT INTO web_shop_products (name, price, number_in_stock)" +
                                                "VALUES ('?', ?, ?)";
    @Override
    public Map<Integer, Product> getProducts(){
        Map<Integer, Product> products = new HashMap<>();

        try (Connection conn =  ConnectionPool.getConnection()) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while(rs.next()){

                Product product = getProduct(rs);
                products.put(product.productId, product);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    private Product getProduct(ResultSet rs) throws SQLException {

        return new Product(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getFloat("price"),
                            rs.getInt("number_in_stock") );
    }



    @Override
    public void setAmount(int productId, int amount) {

        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,amount);
            stmt.setInt(2,productId);

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveProduct(Product product) {

        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1,product.productName);
            stmt.setFloat(2,product.productPrice);
            stmt.setInt(3,product.numberInStock);

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
