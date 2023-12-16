package com.malise.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.malise.app.bean.PatientBeanI;
import com.malise.app.model.entity.Patient;

@Path("/patients")
public class PatientRestApi extends BaseRestApi {

  @EJB
  private PatientBeanI patientBean;

  @Path("/add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Patient patient) {
    patientBean.add(patient);
    return respond("patient Added Successfully");
  }

  @Path("/list")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list() {
    return respond(patientBean.getList(new Patient()));
  }

  @Path("/list/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list(@PathParam("id") Long id) {
    Patient patient = patientBean.getPatientID(id.intValue());
    if (patient != null) {
      return respond(patient);
    } else {
      // Handle the case where the doctor with the specified ID is not found
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

}
