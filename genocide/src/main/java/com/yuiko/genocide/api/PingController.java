package com.yuiko.genocide.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/ping")
public class PingController {

    public PingController() {

    }

    @GET
    @Produces({ "text/plain-text" })
    public Response ping() {
        return Response.ok("pong").build();
    }
}
