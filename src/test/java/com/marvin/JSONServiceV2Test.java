package com.marvin;

//import org.apache.log4j.Logger;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class JSONServiceV2Test {


    private static final String EDO = "EDO";
    private static final String HANOI = "HANOI";
    public static final String VANCOUVER = "Vancouver";
    private Product productHanoi;
    private Product productVancouver;
    @Mock
    private Logger logger;

    @InjectMocks
    private final JSONServiceV2 jsonServiceV2 = new JSONServiceV2();



    @Before
    public void initializeDependencies(){
        productHanoi = new Product(HANOI, 42);
        productVancouver = new Product(VANCOUVER, 42);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProduct(){
        Product product = jsonServiceV2.getProduct();

        assertEquals(EDO, product.getName());
    }

    @Test
    public void createProduct(){
        Response response = jsonServiceV2.createProduct(productHanoi);

        assertEquals(productHanoi, response.getEntity());
    }

    @Test
    public void createCorrectProduct(){
        Response response = jsonServiceV2.createProduct(productHanoi);

        assertNotSame(productVancouver, response.getEntity());
    }
}
