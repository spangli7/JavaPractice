package exams.mvc_sql_practice.webshop.model;

public class Product {
    public int productId;
    public String productName;
    public float productPrice;
    public int numberInStock;

    public Product(int productId, String productName, float productPrice, int numberInStock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.numberInStock = numberInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", numberInStock=" + numberInStock +
                '}';
    }
}
