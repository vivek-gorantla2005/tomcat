import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookie extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter pw = res.getWriter();

        Cookie[] ck = req.getCookies();

        if (ck != null && ck.length > 0) {
            pw.println("<h3>Welcome " + ck[0].getValue() + "</h3>");
        } else {
            pw.println("<h3>No cookies found!</h3>");
        }
        pw.close();
    }
}
