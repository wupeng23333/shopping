package servlet;

import beans.*;
import dao.OrderDao;
import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            out.print("<script>alert('请登录！');window.location.href='login.jsp';</script>");
        else {
            Cart cart = (Cart) session.getAttribute("cart");
            List<Order> orderList = new ArrayList<>();
            for (CartItem cartItem : cart.getList()) {
                Order order = new Order();
                order.setOrdertime(new Date(new java.util.Date().getTime()));// 获取当前时间
                order.setTotal(cart.getTotal());// 获取当前总金额
                order.setAddress("xxxxxxx");
                order.setName(user.getName());// 将当前用户放入到订单当中
                order.setPname(cartItem.getProduct().getPname());
                order.setTelephone(user.getTelephone());
                order.setUid(user.getUid());
                order.setPid(cartItem.getProduct().getPid());
                OrderDao orderDao = DaoFactory.getOrderDaoInstance();
                try {
                    orderDao.SaveOrder(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                orderList = DaoFactory.getOrderDaoInstance().AllOrder();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("orderList", orderList);
            response.sendRedirect("order.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
