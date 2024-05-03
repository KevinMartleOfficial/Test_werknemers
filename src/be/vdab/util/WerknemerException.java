package be.vdab.util;

public class WerknemerException extends RuntimeException{

    private String omschrijving;

    public WerknemerException(){};

    public WerknemerException(String omschrijving){
        super(omschrijving);
    }
}
