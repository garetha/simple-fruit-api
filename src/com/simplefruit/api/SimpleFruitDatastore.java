package com.simplefruit.api;

import com.simplefruit.api.fruit.Fruit;

/**
 * Created by IntelliJ IDEA.
 * User: ross.beazley
 * Date: 18/09/2012
 * Time: 14:16
 */
public class SimpleFruitDatastore implements FruitDatastore {

/*

    A really bad implementation of this method might be

    public String getImagePathForId(String id) {
        String image="";
        if(id.equals("1")) {
           image = "apple.jpg";
        } else if(id.equals("2")) {
           image = "orange.jpg";
        }

        String imageDirRoot = "web/";
        return imageDirRoot + image;
    }


    */


    public String getImagePathForId(String id) {
        Fruit fruit = Fruit.getForId(id);
        if(fruit != null)
            return imageDirRoot + fruit.getImage();
        else
            return null;

    }
}
