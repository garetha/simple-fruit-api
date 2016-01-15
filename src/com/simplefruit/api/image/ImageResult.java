package com.simplefruit.api.image;

import java.io.FileNotFoundException;

import javax.ws.rs.core.StreamingOutput;

/**
 * Created by IntelliJ IDEA.
 * User: ross.beazley
 * Date: 18/09/2012
 * Time: 10:15
 */
public interface ImageResult {
    StreamingOutput invoke() throws FileNotFoundException;
}
