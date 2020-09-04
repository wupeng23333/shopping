package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "IsLoginFilter")
public class IsLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session == null || session.getAttribute("user") == null)
            out.print("<script>alert('请登录！');window.location.href='index.jsp';</script>");
        else chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
