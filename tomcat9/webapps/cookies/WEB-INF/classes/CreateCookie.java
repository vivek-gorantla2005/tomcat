import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateCookie extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter pw = res.getWriter();

        String username = req.getParameter("username");

        if (username != null && !username.isEmpty()) {
            Cookie ck = new Cookie("user", username);
            res.addCookie(ck);
            pw.println("<h3>Cookie created successfully!</h3>");
            pw.println("<h2>acces it here <a href='/cookies/ReadCookie'>read cookie</a>!</h2>");
        } else {
            pw.println("<h3>Cookie creation failed, please try again!</h3>");
        }

        pw.close();
    }
}
