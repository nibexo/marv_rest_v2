package com.marvin;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceStandard {

    public static final String STANDARD_JSON = "Standard json";
    @Inject
    private Logger logger;

    /*
    Example curl:
    curl -H "Content-Type: application/json" -X GET "http://localhost:8080/marvin/json/product/"
    */
    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct() {
        logger.warn(STANDARD_JSON);

        Product product = new Product();
        product.setName("KYOTO");
        product.setQty(1);

        return product;
    }

    /*
    Example curl:
    curl -H "Content-Type: application/json" -X POST "http://localhost:8080/marvin/json/product/" -d '{"qty":999,"name":"iPad 32 */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        logger.warn(STANDARD_JSON);

        product.setName(product.getName());
        String result = "Product created (from standard json MIME): " + product;

        logger.info(result);
        return Response.status(201).entity(product).build();
    }
}

