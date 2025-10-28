<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    HttpSession session = request.getSession(false);
    String uname = (String)session.getAttribute("username");
    if (uname == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<body>
    <h2>Welcome, <%= uname %>!</h2>
    <a href="logout.jsp">Logout</a>
</body>
</html>
