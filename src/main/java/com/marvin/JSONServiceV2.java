package com.marvin;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceV2 {

    public static final String APPLICATION_VND_ERI_V1_JSON_V_2 = "application/vnd.eri-v1+json;v=2";
    @Inject
    private Logger logger;

//    @GET
//    @Path("/get2")
//    @Produces("application/json")
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("SPARTA");
        product.setQty(2);

        return product;

    }

//    @POST
//    @Path("/post2")
//    @Consumes("application/json")
    public Response createProductInJSON(Product product) {

        String result = "Product created : " + product;
        return Response.status(201).entity(result).build();

    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_VND_ERI_V1_JSON_V_2)
    @Produces(APPLICATION_VND_ERI_V1_JSON_V_2)
    public Response createProductInCustomJSON(Product product) {
        logger.warn("Very good custom V2");
        product.setName(product.getName()+" custom MIME V2");
        String result = "Product created : " + product;
        logger.error(result);
        return Response.status(201).entity(product).build();

    }

    @GET
    @Path("/")
    @Consumes(APPLICATION_VND_ERI_V1_JSON_V_2)
    @Produces(APPLICATION_VND_ERI_V1_JSON_V_2)
    public Product getProductInJSON2() {

        logger.info("very good custom V2");

        Product product = new Product();
        product.setName("EDO custom V2");
        product.setQty(2);

        return product;

    }

}