package dao.factory;

import beans.Cart;
import beans.Order;
import beans.Product;
import dao.*;
import dao.impl.*;

public class DaoFactory {
    public static UserDao getUserDAOInstance() {
        return new UserDaoImpl();
    }

    public static CategoryDao getCategoryDaoInstance() {
        return new CategoryDaoImpl();
    }

    public static ProductDao getProductDaoInstance() {
        return new ProductDaoImpl();
    }

    public static CartDao getCartDaoInstance() {
        return new CartDaoImpl();
    }

    public static OrderDao getOrderDaoInstance() {
        return new OrderDaoImpl();
    }
}

