package exams.mvc_sql_practice.webshop.dao;



import exams.mvc_sql_practice.webshop.model.User;

import java.util.Map;

public interface UserDao {
    //TODO: read all users
    Map<Integer, User> getUsers();

    //TODO:  add new users
    void saveUser(User user);

}
