package exams.mvc_sql_practice.webshop.dao;



import exams.mvc_sql_practice.webshop.model.Product;

import java.util.Map;

public interface ProductDao {
    //TODO: read all product
    Map<Integer, Product> getProducts();

    // TODO: set amount
    void setAmount(int productId, int amount);


    // TODO: add new product
    void saveProduct(Product product);

}
