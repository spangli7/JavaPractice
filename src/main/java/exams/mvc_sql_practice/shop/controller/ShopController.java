package exams.mvc_sql_practice.shop.controller;


import exams.mvc_sql_practice.shop.dao.GetAllProducts;
import exams.mvc_sql_practice.shop.dao.GetPurchase;
import exams.mvc_sql_practice.shop.dao.SavePurchaseCost;
import exams.mvc_sql_practice.shop.model.CashRegister;
import exams.mvc_sql_practice.shop.model.Customer;
import exams.mvc_sql_practice.shop.model.GetAmount;
import exams.mvc_sql_practice.shop.model.Purchase;


import java.util.*;

public class ShopController {
    GetAllProducts getAllProducts = new GetAllProducts();
    GetPurchase getAllPurchase = new GetPurchase();
    SavePurchaseCost savePurchaseCost = new SavePurchaseCost();

    Map<Integer,String> products;
    List<Purchase> purchase;
    Map<Integer,List<Customer>> customers;
    Map<Integer, CashRegister> productsAndAmount;

    public int getAllBuying(){
        Map<Integer,List<Customer>> customers = getCustomers();
        return customers.size();
    }

    public int getFirstCustomerPurchase(){
        Map<Integer,List<Customer>> customers = getCustomers();

        int id = customers.keySet().stream()
                .min(Comparator.comparingInt(m->m.compareTo(m)))
                .orElse(0);

        return customers.get(id).size();
    }

    public int getFirstCustomerByBought(String product){
        return getAllBoughtByProduct(product).get(0);
    }

    public int getLastCustomerByBought(String product){
        return getAllBoughtByProduct(product).get(getAllBoughtByProduct(product).size()-1);
    }

    public int getAllCustomersByBought(String product){
        return getAllProducts(product);
    }

    public CashRegister getAllProductsByCustomer(int customerId){
        return  getAllProductsByAllCustomer().get(customerId);
    }

    public void savePurchaseCost(){
        Map<Integer,CashRegister> productsAndAmount = getAllProductsByAllCustomer();

        for (Map.Entry<Integer,CashRegister> product : productsAndAmount.entrySet()) {
            savePurchaseCost.savePurchase(product.getKey(),product.getValue().amount);
        }
    }


    public Map<Integer,CashRegister> getAllProductsByAllCustomer(){
        productsAndAmount = new HashMap<>();
        Map<Integer,List<Customer>> allCustomers = getCustomers();
        Map<String,Integer> produceOfNumber = new HashMap<>();

        for (Map.Entry<Integer,List<Customer>> customers : allCustomers.entrySet()) {
            List<String> allProducts = new ArrayList<>();

            for (Customer customer : customers.getValue()) {
                produceOfNumber.put(customer.productName,customer.count);
                allProducts.add(customer.productName);
            }
            CashRegister cashRegister = new CashRegister();
            GetAmount amount = new GetAmount();

            cashRegister.products = allProducts;
            cashRegister.amount = amount.getAmount(produceOfNumber);

            productsAndAmount.put(customers.getKey(),cashRegister);
        }
        return productsAndAmount;
    }


    private int getAllProducts(String product){
        Map<Integer,List<Customer>> customers = getCustomers();
        int sum = 0;
        for (List<Customer> cart : customers.values()) {
            for (Customer c : cart) {
                if(c.productName.equals(product)){
                    sum++;
                }
            }
        }
        return sum;
    }


    private List<Integer> getAllBoughtByProduct(String product){
        Map<Integer,List<Customer>> customers = getCustomers();
        List<Integer> allCustomersId = new ArrayList<>();

        for (Map.Entry<Integer,List<Customer>> customer: customers.entrySet()) {
            for (Customer c : customer.getValue() ) {
                if (c.productName.equals(product)){
                    allCustomersId.add(customer.getKey());
                    break;
                }
            }
        }
        Collections.sort(allCustomersId);
        return allCustomersId;
    }


    public Map<Integer,List<Customer>> getCustomers(){
        Map<Integer,List<Customer>> allPurchase = new HashMap<>();
        if(customers == null){

            Map<Integer,String> products = getProducts();
            List<Purchase> purchases = getPurchase();

            for (Purchase purchase : purchases) {
                Customer customer = new Customer(products.get(purchase.productId),purchase.productId,purchase.count);
                allPurchase.computeIfAbsent(purchase.id, k-> new ArrayList<>()).add(customer);
            }
        }
        return allPurchase;
    }


    private Map<Integer,String> getProducts(){
        if(products == null){
            products = getAllProducts.getAllProducts();
        }
        return products;
    }

    private List<Purchase> getPurchase(){
        if(purchase == null){
            purchase = getAllPurchase.getPurchases();
        }
        return purchase;
    }



}
