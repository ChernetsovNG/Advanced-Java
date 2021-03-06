package frontend;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegServlet extends HttpServlet{
    private String login = "";
    private String email = "";
    private String password = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(PageGenerator.getPage("regform.html", null));

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("username");
        email = req.getParameter("email");
        password = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");

        if (login == null || login.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
        }

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("login", login == null ? "" : login);
        pageVariables.put("email", email == null ? "" : email);
        pageVariables.put("password", password == null ? "" : password);

        resp.getWriter().println(PageGenerator.getPage("authform.html", pageVariables));
    }
}
