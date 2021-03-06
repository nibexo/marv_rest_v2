package com.marvin;

import com.marvin.v1.Product;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceV1 {

    public static final String APPLICATION_ERI_V_1 = "application/vnd.eri-v1+json;v=1";
    public static final String APPLICATION_ERI_V_0 = "application/vnd.eri-v1+json";
    public static final String CUSTOM_V1_SOON_WILL_BE_NOT_SUPPORTED = "Custom v1: soon will be not supported";

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
    public Product getProduct() {
        logger.warn(CUSTOM_V1_SOON_WILL_BE_NOT_SUPPORTED);

        Product product = new Product();
        product.setName("ATHENS");
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
    public Response createProduct(Product product) {
        logger.warn(CUSTOM_V1_SOON_WILL_BE_NOT_SUPPORTED);

        product.setName(product.getName());
        String result = "Product created (from custom MIME): " + product;

        logger.info(result);
        return Response.status(201).entity(product).build();
    }
}