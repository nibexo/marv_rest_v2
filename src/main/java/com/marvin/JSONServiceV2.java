package com.marvin;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceV2 {

    public static final String APPLICATION_VND_ERI_V1_JSON_V_2 = "application/vnd.eri-v1+json;v=2";
    public static final String CUSTOM_V2_THE_NEWEST_VERSION = "Custom v2: the newest version";
    @Inject
    private Logger logger;

    /*
    Example curl:
    curl -H "Content-Type: application/vnd.eri-v1+json,v=2" -X GET "http://localhost:8080/marvin/json/product/"
     */
    @GET
    @Path("/")
    @Consumes(APPLICATION_VND_ERI_V1_JSON_V_2)
    @Produces(APPLICATION_VND_ERI_V1_JSON_V_2)
    public Product getProduct() {
        logger.info(CUSTOM_V2_THE_NEWEST_VERSION);

        Product product = new Product();
        product.setName("EDO");
        product.setQty(2);

        return product;
    }

    /*
    Example curl:
    curl -H "Content-Type: application/vnd.eri-v1+json;v=2" -X POST "http://localhost:8080/marvin/json/product/" -d '{"qty":999,"name":"iPad 32"}'
    */
    @POST
    @Path("/")
    @Consumes(APPLICATION_VND_ERI_V1_JSON_V_2)
    @Produces(APPLICATION_VND_ERI_V1_JSON_V_2)
    public Response createProduct(Product product) {
        logger.warn(CUSTOM_V2_THE_NEWEST_VERSION);

        product.setName(product.getName()+" custom MIME V2");
        String result = "Product created : " + product;

        logger.info(result);
        return Response.status(201).entity(product).build();
    }
}