package com.malise.app.rest.api;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.malise.app.bean.AuthBeanI;
import com.malise.app.model.entity.User;

@Provider
@Priority(1)
public class RestAuthFilter implements ContainerRequestFilter {

  @Context
  private ResourceInfo resourceInfo;

  @EJB
  private AuthBeanI authBean;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {

    Method method = resourceInfo.getResourceMethod();

    if (method.isAnnotationPresent(DenyAll.class) || !method.isAnnotationPresent(RolesAllowed.class)) {
      requestContext
          .abortWith(Response.status(Response.Status.FORBIDDEN).entity(new RestResponseWrapper(false, "Not allowed"))
              .type(MediaType.APPLICATION_JSON).build());
      return;
    }
    // GET HEADERS

    final MultivaluedMap<String, String> headers = requestContext.getHeaders();

    // Get Authorization Header
    List<String> authorization = headers.get("Authorization");

    // if no auth header abort
    if (authorization == null || authorization.isEmpty() || authorization.get(0) == null) {
      requestContext
          .abortWith(
              Response.status(Response.Status.FORBIDDEN).entity(new RestResponseWrapper(false, "Unauthorized access "))
                  .type(MediaType.APPLICATION_JSON).build());

      return;
    }

    String basicAuth = authorization.get(0);

    if (!basicAuth.contains("Basic ")) {
      requestContext
          .abortWith(
              Response.status(Response.Status.FORBIDDEN)
                  .entity(new RestResponseWrapper(false, "Basic authentication access is required "))
                  .type(MediaType.APPLICATION_JSON).build());
      return;
    }

    // remove basic from auth remain with encoded credential
    String base64 = basicAuth.replace("Basic ", "");

    byte[] decodeCredentials = Base64.getDecoder().decode(base64);

    System.out.println(new String(decodeCredentials, StandardCharsets.UTF_8));

    String[] usernameAndPassword = new String(decodeCredentials, StandardCharsets.UTF_8).split(":");

    User user = new User();
    user.setUsername(usernameAndPassword[0]);
    user.setPassword(usernameAndPassword[1]);

    try {
      authBean.authenticate(user);
    } catch (SQLException e) {
      requestContext
          .abortWith(
              Response.status(Response.Status.FORBIDDEN)
                  .entity(new RestResponseWrapper(false, "Internal Server Error!!! "))
                  .type(MediaType.APPLICATION_JSON).build());
      return;
      // e.printStackTrace();
    }

  }

  // @Override
  // public void filter(ContainerRequestContext requestContext,
  // ContainerResponseContext responseContext)
  // throws IOException {

  // // Add CORS headers to the response
  // MultivaluedMap<String, Object> headers = responseContext.getHeaders();
  // headers.add("Access-Control-Allow-Origin", "*"); // Adjust based on your
  // needs
  // headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,
  // OPTIONS");
  // headers.add("Access-Control-Allow-Headers", "Origin, Content-Type, Accept,
  // Authorization");
  // headers.add("Access-Control-Allow-Credentials", "true");
  // headers.add("Access-Control-Max-Age", "86400"); // 24 hours
  // }

}
