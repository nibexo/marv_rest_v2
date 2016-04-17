package com.marvin;

//import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class JSONServiceV1Test {


    private static final String ATHENS = "ATHENS";
    private static final String HANOI = "HANOI";
    public static final String VANCOUVER = "Vancouver";
    private Product productHanoi;
    private Product productVancouver;
    @Mock
    private Logger logger;

    @InjectMocks
    private final JSONServiceV1 jsonServiceV1 = new JSONServiceV1();



    @Before
    public void initializeDependencies(){
        productHanoi = new Product(HANOI, 42);
        productVancouver = new Product(VANCOUVER, 42);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProduct(){
        Product product = jsonServiceV1.getProduct();

        assertEquals(ATHENS, product.getName());
    }

    @Test
    public void createProduct(){
        Response response = jsonServiceV1.createProduct(productHanoi);

        assertEquals(productHanoi, response.getEntity());
    }

    @Test
    public void createCorrectProduct(){
        Response response = jsonServiceV1.createProduct(productHanoi);

        assertNotSame(productVancouver, response.getEntity());
    }
}
