package com.yuiko.genocide.api;

import java.util.Arrays;

import com.yuiko.genocide.service.WebClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/deport")
@Produces("application/xml")
public class DeportController {

    @Inject
    WebClientService webClientService;

    @GET
    @Path("{id-from}/{id-to}")
    @ApiOperation(value = "Депортировать всё население города с id-from в город с id-to", notes = "", response = Void.class, tags={ "genocide" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class),
            @ApiResponse(code = 400, message = "Can't find city with such ids", response = Void.class),
            @ApiResponse(code = 500, message = "External Server Error", response = Void.class)
    })
    public Response deportFromCityToAnotherCity(
            @PathParam("id-from")
            @ApiParam("Идентификатор города откуда надо депортировать")
            Long idFrom,
            @PathParam("id-to")
            @ApiParam("Идентификатор города куда надо депортировать")
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
