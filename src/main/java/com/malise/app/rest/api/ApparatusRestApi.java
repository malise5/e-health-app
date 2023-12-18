package com.malise.app.rest.api;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.malise.app.bean.ApparatusBeanI;
import com.malise.app.model.entity.Apparatus;

@Path("/apparatus")
public class ApparatusRestApi extends BaseRestApi {

  @EJB
  private ApparatusBeanI apparatusBean;

  @RolesAllowed("LOGGED_IN")
  @Path("/add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Apparatus apparatus) {
    apparatusBean.add(apparatus);
    return respond();
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list() {
    return respond(apparatusBean.getList(new Apparatus()));
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list(@PathParam("id") Long id) {
    Apparatus apparatus = apparatusBean.getApparatusByID(id.intValue());
    if (apparatus != null) {
      return respond(apparatus);
    } else {
      // Handle the case where the doctor with the specified ID is not found
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/delete/{id}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(@PathParam("id") Long id) {
    Apparatus apparatus = apparatusBean.getApparatusByID(id.intValue());
    if (apparatus != null) {
      apparatusBean.delete(id.intValue());
      return respond("Apparatus deleted successfully");
    } else {
      // Handle the case where the doctor with the specified ID is not found
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

}
