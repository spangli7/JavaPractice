package exams.mvc_sql_practice.shop.model;

import java.util.Map;

public class GetAmount {

    private static final int TOTAL_PRICE = 500;
    private static final int SECOND_SALE_PRICE = 450;
    private static final int THIRD_SALE_PRICE = 400;

    public int getAmount( Map<String,Integer> productsPrice) {
        int amount = 0;

        for (int db : productsPrice.values()) {
            if (db >= 1) {
                amount += TOTAL_PRICE;

                if (db >= 2) {
                    amount += SECOND_SALE_PRICE;

                    if (db >= 3) {
                        amount += (db - 2) * THIRD_SALE_PRICE;
                    }
                }
            }
        }
        return amount;
    }
}
