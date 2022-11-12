package exams.mvc_sql_practice.webshop.model;

public class User {
    public int userId;
    public String userName;
    public String userAddress;
    public String userEmail;

    public User(int userId, String userName, String userAddress, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
