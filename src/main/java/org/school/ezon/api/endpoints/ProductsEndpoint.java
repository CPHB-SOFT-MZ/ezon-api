/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.endpoints;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.school.ezon.api.controllers.Controller;
import org.school.ezon.api.controllers.StateInit;
import org.school.ezon.api.pojo.Product;

/**
 * REST Web Service
 *
 * @author kaspe
 */
@Path("products")
public class ProductsEndpoint {

    Controller ctrl = StateInit.getController();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductsEndpoint
     */
    public ProductsEndpoint() {
    }

    /**
     * Retrieves representation of an instance of
     * org.school.ezon.api.endpoints.ProductsEndpoint
     *
     * @return an instance of java.lang.String
     */
    @Path("/{searchString}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsBySearch(@PathParam("searchString") String search) {
        //TODO return proper representation object
        System.out.println(search);
        return Response.ok(ctrl.getProductsBySearch(search)).build();
    }

    /**
     * Retrieves representation of an instance of
     * org.school.ezon.api.endpoints.ProductsEndpoint
     *
     * @return an instance of java.lang.String
     */
    @Path("/category/{category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByCategory(@PathParam("category") String category) {
        //TODO return proper representation object
        return Response.ok(ctrl.getProductsFromCategory(category)).build();
    }

    /**
     * Retrieves representation of an instance of
     * org.school.ezon.api.endpoints.ProductsEndpoint
     *
     * @return an instance of java.lang.String
     */
    @Path("/{category}/{searchString}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsBySearchAndCategory(@PathParam("searchString") String search, @PathParam("category") String category) {
        //TODO return proper representation object
        return Response.ok(ctrl.getProductsBySearchAndCategory(category, search)).build();
    }

    @Path("/popular")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPopularProducts() {
        List<Product> products = ctrl.getPopularProducts();
        return Response.ok(products).build();
    }
}
