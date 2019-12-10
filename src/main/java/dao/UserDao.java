package dao;

import entity.User;
import util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao userDao;
    Util util = new Util();
    Connection connection = util.getConnection();

    private UserDao(){

    }
    public static UserDao getUserDao(){
        if(userDao == null) {
            userDao = new UserDao();
        } return userDao;
    }
    public void createUser(String name, String password, int age){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name, password, age) values(?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(int id, String name, String password, int age) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update user set name = ?, password = ?, age = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String readUser(int id){
        PreparedStatement preparedStatement = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("select * from user where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int Id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            int age = resultSet.getInt("age");
            user = new User(Id, name, password, age);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.toString();
    }
    public List<User> readAllUsers() throws SQLException {
        List<User> clients = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            int age = resultSet.getInt("age");
            clients.add(new User(id, name, password, age));
        }
        return clients;
    }
}