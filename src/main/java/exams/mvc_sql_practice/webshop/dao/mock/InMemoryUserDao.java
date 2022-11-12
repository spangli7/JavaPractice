package exams.mvc_sql_practice.webshop.dao.mock;


import exams.mvc_sql_practice.webshop.dao.UserDao;
import exams.mvc_sql_practice.webshop.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDao implements UserDao {
    Map<Integer, User> users = new HashMap<>();

    {users.put(1,new User(1,"karcsi","kakasto","karcsikukac"));
     users.put(2,new User(2,"lajos","kakasto","lajoskukac"));

    }




    @Override
    public Map<Integer, User> getUsers() {
        return users;
    }

    @Override
    public void saveUser(User user) {
        users.put(user.userId,user);
    }
}
