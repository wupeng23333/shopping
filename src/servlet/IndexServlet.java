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

@WebServlet(name = "IndexServlet", urlPatterns = "/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDao productDao = DaoFactory.getProductDaoInstance();
        List<Product> list01 = null;
        List<Product> list02 = null;
        try {
            list01 = productDao.findHots();
            list02 = productDao.findNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("hots", list01);//最热商品
        session.setAttribute("news", list02);//最新商品
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
