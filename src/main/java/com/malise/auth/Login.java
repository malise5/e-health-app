package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login", initParams = {
    @WebInitParam(name = "username", value = "malise"),
    @WebInitParam(name = "password", value = "malise123"),
})
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // Get the "username" and "password" parameters from the request form.
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    // Check if the entered username and password match the expected values.
    // if (username.equals("malise") && password.equals("malise123"))
    if (username.equals(getInitParameter("username")) && password.equals(getInitParameter("password"))) {

      // If the username and password are correct, create a RequestDispatcher to
      // forward the request to a different page.
      // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/home.html");
      // => redirects to home page

      req.setAttribute("homeinfo", "welcome to E-Health Home page");
      RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
      dispatcher.forward(req, resp);

      // Use the RequestDispatcher to include (forward) the request and response
      // objects to the target page.
      // dispatcher.include(req, resp);

      // Note: The dispatcher.include(req, resp); Itredirect but includes the content
      // of the "home.html" page within the current response.

      // ?resp.sendRedirect('./app/home.html') will include the path in the url

    } else {
      // If the entered username and password are incorrect, create a PrintWriter to
      // send a response to the client.
      PrintWriter print = resp.getWriter();

      // Send an HTML response indicating that the username and password are incorrect
      // and provide a link to login again.
      print.print("<html><body><h2>Wrong username and password <a href=\".\">Login again</a></h2></body></html>");
    }
  }

}
