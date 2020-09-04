package dao;

import beans.Order;

import java.util.List;

public interface OrderDao {
    //保存订单
    public void SaveOrder(Order order) throws  Exception;
    //所有订单
    public List<Order> AllOrder() throws  Exception;
}
