package com.simplefruit.api;

/**
 * Created by IntelliJ IDEA.
 * User: ross.beazley
 * Date: 18/09/2012
 * Time: 11:17
 */
public interface FruitDatastore {

    public static final String imageDirRoot = "web/";

    public String getImagePathForId(String id);


}
