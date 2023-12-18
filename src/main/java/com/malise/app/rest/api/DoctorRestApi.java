package com.malise.app.rest.api;

import javax.annotation.security.DenyAll;
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

import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;

@Path("/doctors")
public class DoctorRestApi extends BaseRestApi {

  @EJB
  private DoctorBeanI doctorBean;

  @RolesAllowed("LOGGED_IN")
  @Path("/add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Doctor doctor) {
    doctorBean.add(doctor);
    return respond(doctor);
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list(@PathParam("id") Long id) {
    Doctor doctor = doctorBean.getDoctorById(id.intValue());
    if (doctor != null) {
      return respond(doctor);
    } else {
      // Handle the case where the doctor with the specified ID is not found
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  @RolesAllowed("LOGGED_IN")
  @Path("/list")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list() {
    return respond(doctorBean.getList(new Doctor()));
  }

}
