package servlet;

import beans.User;
import dao.UserDao;
import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("UTF-8");
        // response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        if ("login".equals(action)) {
            //会员登陆
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            UserDao dao = DaoFactory.getUserDAOInstance();
            try {
                if (dao.login(user)) {
                    session.setAttribute("user", dao.getUserByUserName(username));
                    if(username.equals("admin"))out.print("<script>alert('登录成功');window.location.href='admin.jsp';</script>");
                    else out.print("<script>alert('登录成功');window.location.href='index.jsp';</script>");
                } else out.print("<script>alert('用户名或密码错误');window.location.href='login.jsp';</script>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("register".equals(action)) {
            //会员注册
            String username=request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email=request.getParameter("email");
            String telephone=request.getParameter("telephone");
            String sex=request.getParameter("sex");
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setUsername(username);
            user.setEmail(email);
            user.setTelephone(telephone);
            user.setSex(sex);
            UserDao dao = DaoFactory.getUserDAOInstance();
            try {
                if (dao.checkRegister(user))
                    if (dao.register(user)) {
                        session.setAttribute("user", dao.getUserByUserName(username));
                        out.print("<script>alert('注册成功');window.location.href='index.jsp';</script>");
                    }else out.print("<script>alert('注册失败');window.location.href='register.jsp';</script>");
                else out.print("<script>alert('用户名已存在！');window.location.href='register.jsp';</script>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else out.print("参数错误");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
