package com.malise.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.malise.app.bean.ApparatusBeanI;
import com.malise.app.model.entity.Apparatus;

@Path("/apparatus")
public class ApparatusRestApi extends BaseRestApi {

  @EJB
  private ApparatusBeanI apparatusBean;

  @Path("/add")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Apparatus apparatus) {
    apparatusBean.add(apparatus);
    return respond();
  }

  @Path("/list")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response list() {
    return respond(apparatusBean.getList(new Apparatus()));
  }

}
