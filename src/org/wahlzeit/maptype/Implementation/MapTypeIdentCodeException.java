package org.wahlzeit.maptype.implementation;

/**
 * Created by jonet on 19.01.15.
 */
public class MapTypeIdentCodeException extends Exception {

    private final String message = "Something went wrong with the ident-code argument.\n" +
            "The used ident-code format for country maps is ISO 3166 2-letter code.\n"+
            "For city maps use the ATA 3-letter code which is used on airports";


    @Override
    public String getMessage() {
        return message;
    }

}
