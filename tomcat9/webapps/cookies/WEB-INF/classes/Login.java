import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String password = req.getParameter("password");

        if (uname.equals("admin") && password.equals("admin")) {
            Cookie ck = new Cookie("user", uname);
            res.addCookie(ck);
            out.println("<h3>Login Successful</h3>");
            out.println("<a href='Welcome'>Go to Welcome Page</a>");
        } else {
            out.println("<h3>Login Failed. Try Again.</h3>");
            out.println("<a href='index.html'>Back to Login</a>");
        }
    }
}
