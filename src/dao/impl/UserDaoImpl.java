package dao.impl;

import beans.User;
import dao.UserDao;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public boolean add(User user) throws SQLException {

        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        return false;
    }

    @Override
    public List<User> AllUser() throws SQLException {
        List<User> list=new ArrayList<>();
        pstm=DbUtil.getConnection().prepareStatement("select * from user");
        rs=pstm.executeQuery();
        while (rs.next()){
            User user=new User();
            user.setUid(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setName(rs.getString(4));
            user.setEmail(rs.getString(5));
            user.setTelephone(rs.getString(6));
            user.setSex(rs.getString(7));
            list.add(user);
        }
        return list;
    }


    @Override
    public User findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public boolean login(User user) throws SQLException {
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM user WHERE username like ? AND password like ?");
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        rs = pstm.executeQuery();
        return rs.next();
    }

    @Override
    public boolean register(User user) throws SQLException {
        pstm = DbUtil.getConnection().prepareStatement("INSERT INTO user(username,password,name,email,telephone,sex) values (?,?,?,?,?,?)");
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getName());
        pstm.setString(4, user.getEmail());
        pstm.setString(5, user.getTelephone());
        pstm.setString(6, user.getSex());
        int affectrows = pstm.executeUpdate();
        return affectrows > 0;
    }

    @Override
    public boolean checkRegister(User user) throws SQLException {
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM user WHERE username =?");
        pstm.setString(1, user.getUsername());
        rs = pstm.executeQuery();
        return !rs.next();
    }

    @Override
    public User getUserByUserName(String username) throws SQLException {
        User user = new User();
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM user WHERE username like ?");
        pstm.setString(1, username);
        rs = pstm.executeQuery();
        while (rs.next()) {
            user.setUid(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setName(rs.getString(4));
            user.setEmail(rs.getString(5));
            user.setTelephone(rs.getString(6));
            user.setSex(rs.getString(7));
        }
        return user;
    }
}

