package com.simplefruit.api.image;

/**
 * Created by IntelliJ IDEA.
 * User: ross.beazley
 * Date: 18/09/2012
 * Time: 10:14
 */
public class ImageResultFactory {

    public ImageResult create(String forPath) {
        return new BinaryImageResult(forPath);
//        return new SlowBinaryImageResult(forPath);
    }

}
