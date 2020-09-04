package filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    /**
     * 需要排除的页面
     */
    private String excludedPages;
    private String[] excludedPageArray = {"/index.jsp", "/login.jsp", "/login"};

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();

        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            //将数据存储到session中
            session.setAttribute("isLogin", "false");
            response.getWriter().print("session generate successfully, the ID of session: " + sessionId);
        } else {
            response.getWriter().print("sever has existed the session, the ID of session: " + sessionId);
        }
        Object loginFlag = session.getAttribute("isLogin");     //("isLogin");
        response.getWriter().print("  session.isLogin: " + loginFlag);

        boolean isExcludedPage = false;
        response.getWriter().print("  current.url=" + request.getServletPath()+" current.user="+session.getAttribute("username"));
        for (
                String page : excludedPageArray) {// 判断是否在过滤 url 之外
            if (request.getServletPath().equals(page)) {
                isExcludedPage = true;
                break;
            }
        }

        if (isExcludedPage) {// 在过滤 url 之外
            chain.doFilter(request, response);
        } else {
            if (loginFlag == "false") {
                //没有登录
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('Please login first! 请先登录！out.print');window.location.href='index.jsp';</script>");
                out.flush();
                out.close();
            }
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

