package com.marvin;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONServiceV1 {

    //    curl -X GET "http://localhost:8080/marvin/json/product/" -H "Accept: application/vnd.dakr-v1+json;v=3,*/*;q=0.8"
    @GET
    @Path("/")
    @Consumes({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    @Produces({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    public Product getProductInJSON2() {

        logger.warn("good but soon will be not supported custom V1");

        Product product = new Product();
        product.setName("ATHENS custom V1");
        product.setQty(1);

//        return Response.status(201).entity(product).build();
        return product;

    }
    public static final String APPLICATION_ERI_V_1 = "application/vnd.eri-v1+json;v=1";
    public static final String APPLICATION_ERI_V_0 = "application/vnd.eri-v1+json";

    @Inject
    private Logger logger;

//    @GET
//    @Path("/get1")
//    @Produces("application/json")
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("ROMA");
        product.setQty(1);

        return product;

    }
    @POST
    @Path("/")
    @Consumes({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    @Produces({APPLICATION_ERI_V_1, APPLICATION_ERI_V_0})
    public Response createProductInJSON(Product product) {
        logger.warn("good custom V1");
        product.setName(product.getName()+" custom MIME V1");
        String result = "Product created : " + product;
        logger.error(result);
        return Response.status(201).entity(product).build();

    }
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductInAJSON(Product product) {
        logger.warn("good json");
        String result = "Product created : " + product;
        product.setName(product.getName()+" json not custom");
        logger.error(result);
        return Response.status(201).entity(product).build();

    }

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductInAJSON2() {

        logger.warn("good json");

        Product product = new Product();
        product.setName("ATHENS json not custom");
        product.setQty(1);

//        return Response.status(201).entity(product).build();
        return product;

    }

}