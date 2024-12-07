package com.yuiko.genocide.api;

import java.util.Arrays;

import com.yuiko.genocide.service.WebClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/deport")
//@Produces("application/xml")
public class DeportController {

    @Inject
    WebClientService webClientService;

    @GET
    @Path("{id-from}/{id-to}")
    public Response deportFromCityToAnotherCity(
            @PathParam("id-from")
            Long idFrom,
            @PathParam("id-to")
            Long idTo
    ) {
        Integer code;
        System.out.println(idFrom + " " + idTo);
        try {
             code = webClientService.deportFromCityToAnother(idFrom, idTo);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));;
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
