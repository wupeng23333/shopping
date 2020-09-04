package dao.impl;

import beans.Order;
import dao.OrderDao;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void SaveOrder(Order order) throws Exception {

        PreparedStatement pstm = DbUtil.getConnection().prepareStatement("INSERT INTO od(ordertime,total,address,name,pname,telephone,uid,pid) values (?,?,?,?,?,?,?,?)");
        pstm.setString(1, String.valueOf(order.getOrdertime()));
        pstm.setString(2, String.valueOf(order.getTotal()));
        pstm.setString(3, order.getAddress());
        pstm.setString(4, order.getName());
        pstm.setString(5, order.getPname());
        pstm.setString(6, order.getTelephone());
        pstm.setString(7, String.valueOf(order.getUid()));
        pstm.setString(8, String.valueOf(order.getPid()));
        pstm.executeUpdate();
    }

    @Override
    public List<Order> AllOrder() throws Exception {
        List<Order> list=new ArrayList<>();
        PreparedStatement pstm= DbUtil.getConnection().prepareStatement("select * from od ");
        ResultSet rs=pstm.executeQuery();
        while (rs.next()){
            Order order=new Order();
            order.setOid(rs.getInt(1));
            order.setOrdertime(rs.getDate(2));
            order.setTotal(rs.getInt(3));
            order.setAddress(rs.getString(4));
            order.setName(rs.getString(5));
            order.setPname(rs.getString(6));
            order.setTelephone(rs.getString(7));
            order.setUid(rs.getInt(8));
            order.setPid(rs.getInt(9));
            list.add(order);
        }
        return list;
    }

}
