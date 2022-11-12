package exams.mvc_sql_practice.webshop.controller;


import exams.mvc_sql_practice.webshop.dao.OrderDao;
import exams.mvc_sql_practice.webshop.dao.ProductDao;
import exams.mvc_sql_practice.webshop.dao.UserDao;
import exams.mvc_sql_practice.webshop.dao.mock.InMemoryOrderDao;
import exams.mvc_sql_practice.webshop.dao.mock.InMemoryProductDao;
import exams.mvc_sql_practice.webshop.dao.mock.InMemoryUserDao;
import exams.mvc_sql_practice.webshop.model.Order;
import exams.mvc_sql_practice.webshop.model.Product;
import exams.mvc_sql_practice.webshop.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    OrderDao orderDao = new InMemoryOrderDao();
    ProductDao productDao = new InMemoryProductDao();
    UserDao userDao = new InMemoryUserDao();

    Map<Integer, User> users;
    Map<Integer, Product> products;
    Map<Integer, Order> orders;

    Map<Integer, Order> cart = new HashMap<>();




   public void addProductToCart(int userId, int productId, int amount){
       Order order = cart.computeIfAbsent(userId,k->new Order(userId));

       Map<Integer, Product> products = getProducts();

       Product product = products.get(productId);
       if(amount > product.numberInStock){
           throw new RuntimeException(" not enough ");
       }
       order.orderPrice += product.productPrice * amount;
       order.productId.put(productId,amount);
   }


   public void finaliseOrder(int userId){
       Order order = cart.remove(userId);
       if(order == null){
           throw new RuntimeException("ures kosar ");
       }
       Map<Integer, Product> products = getProducts();

       for (Map.Entry<Integer, Integer> o : order.productId.entrySet()){
            Product product = products.get(o.getKey());
            product.numberInStock -= o.getValue();

           productDao.setAmount(o.getKey(),product.numberInStock);
       }
       orderDao.saveOrder(order);
   }




    public void saveProduct(int productId, String productName, float productPrice, int numberInStock){
        Product product = new Product( productId, productName, productPrice, numberInStock);
        productDao.saveProduct(product);
        getRefresh();
    }


    public List<String> getCartContents(int id){
        List<String> cartContents = new ArrayList<>();
        Order order = cart.get(id);

        for (Map.Entry<Integer,Integer> product : order.productId.entrySet()) {
           cartContents.add(products.get(product.getKey()).productName + " " + products.get(product.getValue()));
        }
        return cartContents;
    }


    public List<Product> getProduct(String productName){
        List<Product> productList = new ArrayList<>();
        Map<Integer, Product> products = getProducts();

        for(Map.Entry<Integer,Product> product : products.entrySet()){
            if(product.getValue().productName.contains(productName)){
                productList.add(product.getValue());
            }
        }
        return productList;
    }



    private void getRefresh(){
        products = productDao.getProducts();
    }


    private Map<Integer, User> getUser(){
       if(users == null){
           users = userDao.getUsers();
       }
       return users;
    }

    private Map<Integer, Product> getProducts(){
       if(products == null){
           products = productDao.getProducts();
       }
       return products;
    }

    private Map<Integer, Order> getOrders(){
       if(orders == null){
           orders = orderDao.getOrders();
       }
       return orders;
    }

}
