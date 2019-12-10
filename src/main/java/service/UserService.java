package service;

import dao.UserDao;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }
    private UserService(){

    }
    public void createUser(String name, String pasword, int age){
        UserDao.getUserDao().createUser(name, pasword, age);
    }
    public void updateUser(int id, String name, String pasword, int age){
        UserDao.getUserDao().updateUser(id, name, pasword, age);
    }
    public void deleteUser(int id){
        UserDao.getUserDao().deleteUser(id);
    }
    public String readUser(int id){
        return UserDao.getUserDao().readUser(id);
    }
    public List<User> readAllUsers() throws SQLException {
        return UserDao.getUserDao().readAllUsers();
    }
}
