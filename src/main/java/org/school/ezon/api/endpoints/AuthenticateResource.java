/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.endpoints;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author kaspe
 */
@Path("Authenticate")
public class AuthenticateResource {
    
    Facade facade = UserFacadeFactory.getInstance()

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthenticateResource
     */
    public AuthenticateResource() {
    }

    /**
     * Retrieves representation of an instance of org.school.ezon.api.endpoints.AuthenticateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AuthenticateResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(String email, String password) {
        return Response.ok(facade.createUser(email, password)).build();
    }
}
