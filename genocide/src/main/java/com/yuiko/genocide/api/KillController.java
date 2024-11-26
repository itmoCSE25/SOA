package com.yuiko.genocide.api;

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

@Path("/kill")
@Produces("application/xml")
public class KillController {

    @Inject
    WebClientService webClientService;

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Уничтожить всё население города с заданным id", notes = "", response = Void.class, tags={ "genocide" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class),
            @ApiResponse(code = 400, message = "Can't find city with such ids", response = Void.class),
            @ApiResponse(code = 500, message = "External Server Error", response = Void.class)
    })
    public Response killAllInCityById(
            @PathParam("id")
            @ApiParam("Идентификатор города в котором необходимо уничтожить все население")
            Long id
    ) {
        if (webClientService.killByCityId(id) != null) {
            return Response.ok().entity(webClientService.killByCityId(id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
