package servlet;

import beans.Cart;
import beans.CartItem;
import beans.Product;
import dao.CartDao;
import dao.ProductDao;
import dao.factory.DaoFactory;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        Cart cart0= (Cart) session.getAttribute("cart");
        if (action.equals("add")) {
            try {
                int pid = Integer.parseInt(request.getParameter("pid"));
                ProductDao productDao = DaoFactory.getProductDaoInstance();
                Product product = null;product = productDao.getProductByPid(pid);
                int num = Integer.parseInt(request.getParameter("num"));
                CartDao cartDao=DaoFactory.getCartDaoInstance();
                Cart cart=cartDao.addCartItemToCart(product,num);
                session.setAttribute("cart",cart);
                response.sendRedirect("cart.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将所选商品添加到购物车并返回到购物车页面
        }
        if (action.equals("clear")) {
            CartDao cartDao=DaoFactory.getCartDaoInstance();
            Cart cart= null;
            session.setAttribute("cart", cart);
            response.sendRedirect("cart.jsp");//清空购物车
        }
        if(action.equals("del")){

            try {
                CartDao cartDao=DaoFactory.getCartDaoInstance();
                int pid = Integer.parseInt(request.getParameter("pid"));
                ProductDao productDao = DaoFactory.getProductDaoInstance();
                Product product = null;product = productDao.getProductByPid(pid);
                Cart cart=cartDao.delProduct(product,cart0);
                session.setAttribute("cart", cart);
                response.sendRedirect("cart.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
