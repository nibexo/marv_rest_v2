package com.marvin.provider;


import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by dakr on 16.04.16.
 */

@Provider
//@Consumes("application/ason")
//@Produces("application/ason")
public class MyCustomReader implements MessageBodyReader, MessageBodyWriter{


    public static final String VND_ERI_JSON = "vnd.eri-v1+json";
    public static final String APPLICATION = "application";

    @Override
    public boolean isReadable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        System.out.println(mediaType.getParameters());
        System.out.println(mediaType.getSubtype());
        System.out.println(mediaType.getType());

        if(mediaType.getType().equals(APPLICATION) &&
                mediaType.getSubtype().equals(VND_ERI_JSON)) {
            return true;
        }else {
            return false;
        }
    }

    public MyCustomReader() {
    }

    @Override
    public Object readFrom(Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, InputStream entityStream) throws IOException, WebApplicationException{
        Object value = null;
        Gson gson = new GsonBuilder().create();

            Reader reader = new InputStreamReader(entityStream);
            value = gson.fromJson(reader, genericType);


        return value;
    }

    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if(mediaType.getType().equals(APPLICATION) &&
                mediaType.getSubtype().equals(VND_ERI_JSON)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public long getSize(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Object object, Class type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {

        Gson gson = new GsonBuilder().create();

        Writer writer = new OutputStreamWriter(entityStream);
        String responeJson = gson.toJson(object);
        writer.write(responeJson);
        writer.flush();
        writer.close();

    }
}
