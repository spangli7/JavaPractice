package exams.mvc_sql_practice.webshop.dao.mock;



import exams.mvc_sql_practice.webshop.dao.ProductDao;
import exams.mvc_sql_practice.webshop.model.Product;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductDao implements ProductDao {
    Map<Integer, Product> products = new HashMap<>();

    {
        products.put(1,new Product(3,"kacsazsir",999,2113));
        products.put(2,new Product(4,"libazsir",799,1112));
    }

    @Override
    public Map<Integer, Product> getProducts() {
        return products;
    }

    @Override
    public void setAmount(int productId, int amount) {
        products.get(productId).productPrice = amount;
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.productId, product);
    }
}
