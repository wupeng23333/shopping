package servlet;

import beans.Category;
import beans.Product;
import dao.CategoryDao;
import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CategoryServlet",urlPatterns = "/categoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CategoryDao categoryDao= DaoFactory.getCategoryDaoInstance();
        List<Product> list= null;
        int cid=Integer.parseInt(request.getParameter("cid"));
        try {
            list = categoryDao.getAllProductByCategory(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("categoryProduct",list);
        response.sendRedirect("product.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
