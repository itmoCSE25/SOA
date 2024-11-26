package com.yuiko.genocide.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/ping")
@Api("the Utility API")
public class PingController {

    public PingController() {

    }

    @GET
    @Produces({ "text/plain-text" })
    @ApiOperation(value = "", notes = "", response = String.class, tags={ "utility" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class)
    })
    public Response ping() {
        return Response.ok("pong").build();
    }
}
