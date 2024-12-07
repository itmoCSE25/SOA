package com.yuiko.genocide.api;

import com.yuiko.genocide.service.WebClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/kill")
@Produces("application/xml")
public class KillController {

    @Inject
    WebClientService webClientService;

    @GET
    @Path("{id}")
    public Response killAllInCityById(
            @PathParam("id")
            Long id
    ) {
        Integer code = webClientService.killByCityId(id);
        if (code == 200) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
