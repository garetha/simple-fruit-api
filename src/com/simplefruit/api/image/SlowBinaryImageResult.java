package com.simplefruit.api.image;

import java.io.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

/**
 * Created by IntelliJ IDEA.
 * User: ross.beazley
 * Date: 18/09/2012
 * Time: 10:13
 */
public class SlowBinaryImageResult implements ImageResult {

     private String image;

        public SlowBinaryImageResult(String image) {
            this.image = image;
        }

        public StreamingOutput invoke() throws FileNotFoundException {

            File ab = new File(image);
            final FileInputStream reader = new FileInputStream(ab);

            return new StreamingOutput(){

                public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                    int read;
                    while( (read = reader.read()) != -1 ) {
                        outputStream.write(read);
                        waitSomeMillis();
                    }
                }
            };
        }

    private static void waitSomeMillis() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
             //e.printStackTrace();
        }
    }
}
