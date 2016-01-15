package com.simplefruit.api;

import java.io.*;

import javax.ws.rs.*;
import javax.ws.rs.core.StreamingOutput;

import com.simplefruit.api.fruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simplefruit.api.image.ImageResultFactory;


public class RestAPI {

    private static final Logger LOG = LoggerFactory.getLogger(RestAPI.class);

    ImageResultFactory irFactory;

    FruitDatastore fruitStore;

    public RestAPI(ImageResultFactory irFactory, FruitDatastore fruitStore) {
        this.irFactory = irFactory;
        this.fruitStore = fruitStore;
    }

    @GET
    @Path("image/{id}")
    @Produces("image/jpeg")
    public StreamingOutput fruitImage(@PathParam("id") String id) throws FileNotFoundException {

        String fullPath = fruitStore.getImagePathForId(id);

        return irFactory.create(fullPath).invoke();
    }


    @GET
    @Path("fruit")
    @Produces("application/json")
    public String fruitList() throws FileNotFoundException {
        Fruit[] fruits = Fruit.values();
        StringBuilder jsonBuilder = new StringBuilder("{\"fruit\":[");
        jsonBuilder.append(fruits[0].toJSON());

        for(int i = 1; i < fruits.length; i++) {
            jsonBuilder.append(",").append(fruits[i].toJSON());
        }

        jsonBuilder.append("]}");
        return jsonBuilder.toString();
    }



}