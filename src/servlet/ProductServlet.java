package servlet;

import beans.Product;
import dao.ProductDao;
import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int pid=Integer.parseInt(request.getParameter("pid"));
        ProductDao productDao=DaoFactory.getProductDaoInstance();
        Product product= null;
        try {
            product = productDao.getProductByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("product",product);
        response.sendRedirect("product_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
