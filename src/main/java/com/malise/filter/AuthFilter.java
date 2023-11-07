package com.malise.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpSession httpSession = httpRequest.getSession();

    String servletPath = httpRequest.getServletPath();
    System.out.println("servletpath is " + servletPath);
    System.out.println("context path path " + httpRequest.getContextPath());
    System.out.println("context path uri " + httpRequest.getRequestURI());

    if (httpSession.isNew()) {

      httpSession.invalidate();

      if (servletPath.equals("/login") || servletPath.equals("/index.html") || servletPath.equals("/user")
          || servletPath.equals("/sighnup.html")) {

        chain.doFilter(request, response);

      } else {

        httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
        response.getWriter().flush();
      }

    } else {

      if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

        chain.doFilter(request, response);

      } else {

        httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
        response.getWriter().flush();
      }
    }

  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    Filter.super.destroy();
  }

}
