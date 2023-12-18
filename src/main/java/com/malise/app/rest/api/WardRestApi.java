package com.malise.app.rest.api;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.malise.app.bean.WardBeanI;
import com.malise.app.model.entity.Ward;

@Path("/wards")
public class WardRestApi extends BaseRestApi {

  @EJB
  private WardBeanI wardBean;

  @Path("/add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Ward ward) {
    wardBean.add(ward);
    return respond();
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list() {
    return respond(wardBean.getList(new Ward()));
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list(@PathParam("id") Long id) {
    Ward ward = wardBean.getWardByID(id.intValue());
    if (ward != null) {
      return respond(ward);
    } else {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

}
