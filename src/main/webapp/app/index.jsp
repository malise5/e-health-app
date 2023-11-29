<%@ page isELIgnored="false"%>
<%@ page import="com.malise.app.view.toolbar.TopToolbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../style/style.jsp" />
         <!-- Include the external JavaScript file using jsp:include -->
        <%-- <jsp:include page="../javaScript/index.js" /> --%>
    </head>
    <body>
        <nav class="navbar">
            <div class="logo">
            <%-- <h3>Welcome: <%= session.getAttribute("username") %> </h3> --%>
            <h3>Welcome: ${sessionScope.username}</h3>
              <%-- <%= response.getHeader("AuthTime") %> --%>
            </div>
            <jsp:useBean id="navBar" class="com.malise.app.view.toolbar.TopToolbar" />
            <jsp:setProperty name="navBar" property="activeLink"  value='${requestScope.activeMenu}'/>
            ${navBar.menu}
        </nav>
        ${requestScope.content}
        
      <%-- <a href="./logout">Logout</a> --%>
      <%-- <script type="text/javascript" src="../javaScript/index.js"></script> --%>
      <jsp:include page="../javaScript/index.jsp" />
    </body>
</html>

