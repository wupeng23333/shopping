package dao;

import beans.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public boolean add(User user) throws  SQLException;
    public boolean update(User user)throws SQLException;

    public boolean delete(Integer id)throws SQLException;
    //列举所有用户
    public  List<User> AllUser() throws SQLException;
    //根据id查找用户
    public User findById(Integer id)throws SQLException;
    //会员登陆
    public boolean login(User user) throws SQLException;
    //会员注册
    public boolean register(User user) throws SQLException;
    //会员注册验证
    public boolean checkRegister(User user) throws SQLException;
    //根据用户名返回User
    public User getUserByUserName(String username) throws SQLException;
}
