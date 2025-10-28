import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "yourpassword");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username,password) VALUES(?,?)");
            ps.setString(1, uname);
            ps.setString(2, pwd);
            int i = ps.executeUpdate();

            if(i > 0) {
                out.println("<h3>Registration successful! <a href='login.jsp'>Login here</a></h3>");
            } else {
                out.println("<h3>Registration failed</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
