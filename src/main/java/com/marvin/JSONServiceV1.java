package com.marvin;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceV1 {

    public static final String APPLICATION_ERI_V_1 = "application/vnd.eri-v1+json;v=1";
    public static final String APPLICATION_ERI_V_0 = "application/vnd.eri-v1+json";

    @Inject
    private Logger logger;

    /*
    Example curl:
    curl -H "Content-Type: application/vnd.eri-v1+json" -X GET "http://localhost:8080/marvin/json/product/"
    curl -H "Content-Type: application/vnd.eri-v1+json;v=1" -X GET "http://localhost:8080/marvin/json/product/"
     */
    @GET
    @Path("/")
    @Consumes({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    @Produces({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    public Product getProductInJSON2() {
        logger.warn("Custom v1: soon will be not supported");

        Product product = new Product();
        product.setName("ATHENS");
        product.setQty(1);

        return product;
    }

    /*
    Example curl:
    curl -H "Content-Type: application/json" -X GET "http://localhost:8080/marvin/json/product/"
     */
    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductInAJSON2() {
        logger.warn("Standard json");

        Product product = new Product();
        product.setName("ATHENS json not custom");
        product.setQty(1);

        return product;
    }

    /*
    Example curl:
    curl -H "Content-Type: application/vnd.eri-v1+json" -X POST "http://localhost:8080/marvin/json/product/" -d '{"qty":999,"name":"iPad 32"}'
    curl -H "Content-Type: application/vnd.eri-v1+json;v=1" -X POST "http://localhost:8080/marvin/json/product/" -d '{"qty":999,"name":"iPad 32"}'
     */
    @POST
    @Path("/")
    @Consumes({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    @Produces({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    public Response createProductInJSON(Product product) {
        logger.warn("Custom v1: soon will be not supported");

        product.setName(product.getName());
        String result = "Product created (from custom MIME): " + product;

        logger.info(result);
        return Response.status(201).entity(product).build();
    }

    /*
    Example curl:
    curl -H "Content-Type: application/json" -X POST "http://localhost:8080/marvin/json/product/" -d '{"qty":999,"name":"iPad 32"}'
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductInAJSON(Product product) {
        logger.warn("Standard json");

        product.setName(product.getName());
        String result = "Product created (from standard json MIME): " + product;

        logger.info(result);
        return Response.status(201).entity(product).build();
    }
}