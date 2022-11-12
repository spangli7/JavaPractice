package exams.mvc_sql_practice.webshop.dao.sql;


import exams.mvc_sql_practice.webshop.dao.UserDao;
import exams.mvc_sql_practice.webshop.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetUsers implements UserDao {

    private static final String SQL_SELECT = "SELECT * FROM web_shop_users";
    @Override
    public Map<Integer, User> getUsers(){
        Map<Integer, User> users = new HashMap<>();

        try (Connection conn =  ConnectionPool.getConnection()) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while(rs.next()){

                User user = getUser(rs);
                users.put(user.userId, user);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public void saveUser(User user) {

    }

    private User getUser(ResultSet rs) throws SQLException {

        return new User(rs.getInt("id"), rs.getString("name"),rs.getString("address"),
                rs.getString("email") );
    }


}
