package exams.mvc_sql_practice.shop.model;

public class Purchase {
    public int id;
    public int productId;
    public int count;


    public Purchase(int id, int productId, int count) {
        this.id = id;
        this.productId = productId;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }
}
