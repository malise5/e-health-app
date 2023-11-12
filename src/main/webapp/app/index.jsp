<%@ page import="com.malise.app.view.toolbar.TopToolbar" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../style/style.jsp" />
    </head>
    <body>
        <nav class="navbar">
            <div class="logo">
            <h3>Welcome: <%= session.getAttribute("username") %> </h3>
              <%= response.getHeader("AuthTime") %>
            </div>
            <%= new TopToolbar().menu((int)request.getAttribute("activeMenu")) %>
        </nav>
        <%= request.getAttribute("content") %>
        
      <a href="./logout">Logout</a>
    </body>
</html>