import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Welcome extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookies = req.getCookies();        
        String username = cookies[0].getValue();


        if (username != null) {
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            out.println("<h3>No user found. Please login again.</h3>");
            out.println("<a href='index.html'>Login</a>");
        }
    }
}
