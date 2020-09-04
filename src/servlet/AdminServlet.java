package servlet;

import beans.Category;
import beans.Order;
import beans.Product;
import beans.User;
import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/adminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        if(action.equals("category")){
            List<Category> categoryList= null;
            try {
                categoryList = DaoFactory.getCategoryDaoInstance().getAllCategory();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("categoryList",categoryList);
           response.sendRedirect("admincategory.jsp");
        }
        if(action.equals("product")){
            List<Product> productList= null;
            try {
                productList = DaoFactory.getProductDaoInstance().getAllProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("productList",productList);
            response.sendRedirect("adminproduct.jsp");
        }
        if(action.equals("order")){
            List<Order> orderList = null;
            try {
                orderList = DaoFactory.getOrderDaoInstance().AllOrder();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("orderList",orderList);
           response.sendRedirect("adminorder.jsp");
        }
        if (action.equals("user")){
            List<User> userList= null;
            try {
                userList = DaoFactory.getUserDAOInstance().AllUser();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("userList",userList);
            response.sendRedirect("adminuser.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
